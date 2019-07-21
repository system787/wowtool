package system787.wowtool.data.entity;

import com.google.gson.annotations.SerializedName;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class TokenResponseEntity {

    @SerializedName("access_token")
    private String access_token;

    @SerializedName("token_type")
    private String token_type;

    @SerializedName("expires_in")
    private long expires_in;

    @SerializedName("tokenTimestamp")
    private Instant tokenTimestamp;

    public TokenResponseEntity(String access_token, String token_type, long expires_in) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.tokenTimestamp = Instant.now();
    }

    public TokenResponseEntity() {
    }

    public String getAccessToken() {
        return access_token;
    }

    public String getTokenType() {
        return token_type;
    }

    public Instant getTokenTimestamp() {
        return tokenTimestamp;
    }

    public long getExpiresIn() {
        return expires_in;
    }

    public void setTokenTimestamp() {
        this.tokenTimestamp = Instant.now();
    }

    public boolean isTokenExpired() {
        return (getTokenTimestamp().plus(getExpiresIn(), ChronoUnit.SECONDS).isBefore(Instant.now()));
    }
}
