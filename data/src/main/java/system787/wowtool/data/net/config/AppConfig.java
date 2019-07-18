package system787.wowtool.data.net.config;

import com.google.gson.annotations.SerializedName;
import java.net.URL;

public class AppConfig {

    @SerializedName("tokenUrl")
    private URL tokenURL;

    @SerializedName("baseUrl")
    private URL baseURL;

    @SerializedName("authenticationLevel")
    private String authenticationLevel;

    @SerializedName("grantType")
    private String grantType;

    public AppConfig() {}

    public URL getTokenURL() {
        return tokenURL;
    }

    public URL getBaseURL() {
        return baseURL;
    }

    public String getAuthenticationLevel() {
        return authenticationLevel;
    }

    public String getGrantType() {
        return grantType;
    }
}
