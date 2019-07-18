package system787.wowtool.data.net.oauth.model;

public class TokenResponse {

    private String access_token;
    private String token_type;
    private Long expires_in;

    public TokenResponse() {
    }

    public String getAccessToken() {
        return access_token;
    }

    public String getTokenType() {
        return token_type;
    }

    public Long getTokenExpire() {
        return expires_in;
    }
}
