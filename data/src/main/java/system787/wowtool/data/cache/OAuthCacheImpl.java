package system787.wowtool.data.cache;

import io.reactivex.Observable;
import system787.wowtool.data.entity.TokenResponseEntity;

public class OAuthCacheImpl implements OAuthCache {
    //TODO: Implement local data store cache

    @Override
    public Observable<TokenResponseEntity> get() {
        return null;
    }

    @Override
    public void put(TokenResponseEntity entity) {

    }

    @Override
    public boolean isCached() {
        return false;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
