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
    private static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("text/x-markdown; charset=utf-8");

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

            OkHttpClient okHttpClient = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(mAppConfig.getTokenURL())
                    .addHeader(
                            "Authorization",
                            String.format("Basic %s", credentials))
                    .addHeader("grant_type", mAppConfig.getGrantType())
                    .post(
                            RequestBody.create(new byte[]{}, null ))
                    .build();

            logger.atInfo().log("Request Body: " + request.toString());

            Response response = okHttpClient.newCall(request).execute();

            if (!response.isSuccessful()) {

                throw new IOException("Unexpected response: " + response);
            } else {

                String jsonResponse = response.body().string();
                TokenResponse tokenResponse = mJsonObjectMapper.deserialize(jsonResponse, TokenResponse.class);

                synchronized (tokenLock) {
                    tokenExpiry = Instant.now().plusSeconds(tokenResponse.getTokenExpire());
                    token = tokenResponse.getAccessToken();
                }
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
