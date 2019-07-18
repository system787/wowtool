package system787.wowtool.data.net.oauth;

import com.google.common.flogger.FluentLogger;
import okhttp3.*;
import system787.wowtool.data.cache.JsonObjectMapper;
import system787.wowtool.data.net.config.AppConfig;
import system787.wowtool.data.net.config.AppConfigMapper;
import system787.wowtool.data.net.config.EnvConfig;
import system787.wowtool.data.net.oauth.model.TokenResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;

@Singleton
public class OauthApiImpl implements OauthApi {

    // Dependency Injection
    private JsonObjectMapper mJsonObjectMapper;

    // Config
    private AppConfig mAppConfig = AppConfigMapper.mapAppConfig();
    private EnvConfig mEnvConfig = new EnvConfig();

    // Token
    private String token = null;
    private Instant tokenExpiry = null;
    private final Object tokenLock = new Object();

    // Constructor
    @Inject
    public OauthApiImpl(JsonObjectMapper jsonObjectMapper) {
        mJsonObjectMapper = jsonObjectMapper;
    }

    // Logging
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    @Override
    public String getToken() throws IOException {

        if (isTokenInvalid()) {
            String credentials = Base64.getEncoder()
                    .encodeToString(
                            String.format("%s:%s",
                                    mEnvConfig.getClientId(),
                                    mEnvConfig.getClientSecret()
                            ).getBytes(StandardCharsets.UTF_8));

            // String credentials = Credentials.basic(mEnvConfig.getClientId(), mEnvConfig.getClientSecret());

            OkHttpClient okHttpClient = new OkHttpClient();

            RequestBody requestBody = new FormBody.Builder()
                    .add("grant_type", "client_credentials")
                    .build();

            Request request = new Request.Builder()
                    .url(mAppConfig.getTokenURL())
                    .addHeader("Authorization", String.format("Basic %s", credentials))
                    .post(requestBody)
                    .build();

            logger.atInfo().log("Request Body: " + request.toString());
            logger.atInfo().log("Request Header: " + request.headers().toString());

            Response response = okHttpClient.newCall(request).execute();

            if (!response.isSuccessful()) {

                throw new IOException("Unexpected response: " + response);
            }

            String jsonResponse = response.body().string();

            logger.atInfo().log("Response from server: " + jsonResponse);

            TokenResponse tokenResponse = mJsonObjectMapper.deserialize(jsonResponse, TokenResponse.class);

            synchronized (tokenLock) {
                tokenExpiry = Instant.now().plusSeconds(tokenResponse.getTokenExpire());
                token = tokenResponse.getAccessToken();
            }

        }

        synchronized (tokenLock) {
            return token;
        }
    }

    @Override
    public boolean isTokenInvalid() {
        synchronized (tokenLock) {
            if (token == null) {
                return true;
            }

            if (tokenExpiry == null) {
                return true;
            }

            return Instant.now().isAfter(tokenExpiry);
        }
    }
}
