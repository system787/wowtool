package system787.wowtool.data.repository;

import io.reactivex.Observable;
import system787.wowtool.data.entity.mapper.TokenResponseEntityDataMapper;
import system787.wowtool.data.net.oauth.OAuthApiImpl;
import system787.wowtool.domain.TokenResponse;
import system787.wowtool.domain.net.OAuthApi;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class OAuthDataRepository implements OAuthApi {

    private TokenResponseEntityDataMapper mDataMapper;

    @Inject
    public OAuthDataRepository() {
        this.mDataMapper = new TokenResponseEntityDataMapper();
    }

    @Override
    public Observable<TokenResponse> tokenResponse(String encodedCredentials) {
        // TODO: implement loading from disk before requesting new token
        OAuthApiImpl oAuthApi = new OAuthApiImpl();

        return oAuthApi.getToken(encodedCredentials).map(this.mDataMapper::transform);
    }
}
