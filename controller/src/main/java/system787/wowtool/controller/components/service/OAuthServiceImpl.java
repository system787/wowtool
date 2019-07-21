package system787.wowtool.controller.components.service;

import system787.wowtool.controller.components.model.TokenResponseModel;

public class OAuthServiceImpl implements OAuthService {

    @Override
    public TokenResponseModel getNewToken(String encodedCredentials) {
        return null;
    }

    @Override
    public TokenResponseModel getCachedToken() {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public boolean exists() {
        return false;
    }
}
