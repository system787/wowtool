package system787.wowtool.data.net.oauth;

import io.reactivex.Observable;
import system787.wowtool.data.entity.TokenResponseEntity;

public interface OAuthApi {
    Observable<TokenResponseEntity> getToken(String encodedCredentials);
}
