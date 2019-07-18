package system787.wowtool.data.net.oauth;

import java.io.IOException;

public interface OauthApi{

    String getToken() throws IOException;
    boolean isTokenInvalid();

}
