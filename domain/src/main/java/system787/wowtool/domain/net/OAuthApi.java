package system787.wowtool.domain.net;

import io.reactivex.Observable;
import system787.wowtool.domain.TokenResponse;

public interface OAuthApi {

    Observable<TokenResponse> tokenResponse(String encodedCredentials);
}
