package system787.wowtool.data.repository.datasource;

import io.reactivex.Observable;
import system787.wowtool.data.entity.TokenResponseEntity;

public interface OAuthDataStore {
    Observable<TokenResponseEntity> tokenResponseEntity();
}
