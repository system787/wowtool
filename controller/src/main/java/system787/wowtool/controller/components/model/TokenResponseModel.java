package system787.wowtool.controller.components.model;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class TokenResponseModel {
    private String access_token;
    private String token_type;
    private long expires_in;
    private Instant tokenTimestamp;

    public TokenResponseModel(String access_token, String token_type, long expires_in, Instant tokenTimestamp) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.tokenTimestamp = Instant.now();
    }

    public String getAccessToken() {
        return access_token;
    }

    public void setAccessToken(String access_token) {
        this.access_token = access_token;
    }

    public String getTokenType() {
        return token_type;
    }

    public void setTokenType(String token_type) {
        this.token_type = token_type;
    }

    public long getExpiresIn() {
        return expires_in;
    }

    public void setExpiresIn(long expires_in) {
        this.expires_in = expires_in;
    }

    public Instant getTokenTimestamp() {
        return tokenTimestamp;
    }

    public void setTokenTimestamp(Instant tokenTimestamp) {
        this.tokenTimestamp = tokenTimestamp;
    }

    public boolean isTokenExpired() {
        return (getTokenTimestamp().plus(getExpiresIn(), ChronoUnit.SECONDS).isBefore(Instant.now()));
    }
}
