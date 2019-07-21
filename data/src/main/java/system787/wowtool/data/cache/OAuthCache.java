package system787.wowtool.data.cache;

import io.reactivex.Observable;
import system787.wowtool.data.entity.TokenResponseEntity;

public interface OAuthCache {

    Observable<TokenResponseEntity> get();

    void put(TokenResponseEntity entity);

    boolean isCached();

    boolean isExpired();
}
