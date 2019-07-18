package system787.wowtool.data.net.oauth;

public class TokenResponse {

    private String accessToken;
    private String tokenType;
    private Long tokenExpire;

    public TokenResponse(String accessToken, String tokenType, Long tokenExpire) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.tokenExpire = tokenExpire;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Long getTokenExpire() {
        return tokenExpire;
    }

    public void setTokenExpire(Long tokenExpire) {
        this.tokenExpire = tokenExpire;
    }
}
