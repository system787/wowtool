package system787.wowtool.data.net.oauth;

import com.google.common.flogger.FluentLogger;
import com.google.gson.Gson;
import io.reactivex.Observable;
import okhttp3.*;
import system787.wowtool.data.entity.TokenResponseEntity;
import system787.wowtool.data.exception.NetworkConnectionException;

import java.io.IOException;

public class OAuthApiImpl implements OAuthApi {

    private Gson mGson;

    // Config
    private static final String TOKEN_URL = "https://us.battle.net/oauth/token";

    // Logging
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    @Override
    public Observable<TokenResponseEntity> getToken(String encodedCredentials) {
        return Observable.create(emitter -> {
            try {
                TokenResponseEntity tokenResponse = getTokenFromApi(encodedCredentials);

                if (tokenResponse != null) {
                    emitter.onNext(tokenResponse);
                    emitter.onComplete();
                } else {
                    emitter.onError(new NetworkConnectionException());
                }
            } catch (Exception e) {
                emitter.onError(new NetworkConnectionException(e.getCause()));
            }
        });
    }

    private TokenResponseEntity getTokenFromApi(String encodedCredentials) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("grant_type", "client_credentials")
                .build();

        Request request = new Request.Builder()
                .url(TOKEN_URL)
                .addHeader("Authorization", String.format("Basic %s", encodedCredentials))
                .post(requestBody)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();

        Response response = okHttpClient.newCall(request).execute();

        if (!response.isSuccessful()) {
            logger.atWarning().log("Request was invalid.\nRequest body: "
                    + request.toString()
                    + " \nRequest header: " + request.headers().toString());

            throw new IOException("Unexpected response: " + response);
        } else {
            String responseJson = response.body().string();

            logger.atInfo().log("Request successful.\nRequest Body: "
                    + request.toString()
                    + "\nRequest header: " + request.headers().toString()
                    + "\nResponse: " + responseJson);

            mGson = new Gson();

            TokenResponseEntity tokenResponse = mGson.fromJson(responseJson, TokenResponseEntity.class);
            tokenResponse.setTokenTimestamp();

            return tokenResponse;
        }
    }
}
