package system787.wowtool.controller.components.service;

import system787.wowtool.controller.components.model.TokenResponseModel;

public interface OAuthService {

    // Net

    /**
     * Requests a new token from Blizzard, presumably if the old one is expired or nonexistent
     * @param encodedCredentials base64 encoding in the format {CLIENT_ID:CLIENT_SECRET}
     * @return new Token from Blizzard API
     */
    TokenResponseModel getNewToken(String encodedCredentials);

    // Local

    /**
     * Retrieves the existing token from the local data store.
     */
    TokenResponseModel getCachedToken();

    /**
     * Deletes the current token from the local data store.
     */
    void delete();

    /**
     * Checks to see if there is a token residing in the local data store
     */
    boolean exists();
}
