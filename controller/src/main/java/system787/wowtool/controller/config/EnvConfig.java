package system787.wowtool.controller.config;

import com.google.common.flogger.FluentLogger;
import system787.wowtool.data.net.exception.EnvironmentVariablesNotSet;

public class EnvConfig {
    private static final String CLIENT_ID = "BLIZZARD_CLIENT_ID";
    private static final String CLIENT_SECRET = "BLIZZARD_CLIENT_SECRET";

    private String mClientID;
    private String mClientSecret;

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public EnvConfig() {
        try {
            setClientEnv();
        } catch (EnvironmentVariablesNotSet e) {
            logger.atWarning()
                    .withCause(e)
                    .log("Blizzard Client ID and/or Client Secrets not set in environment variables");
        }
    }

    public String getClientId() {
        return mClientID;
    }

    public String getClientSecret() {
        return mClientSecret;
    }

    private void setClientEnv() throws EnvironmentVariablesNotSet {
        mClientID = System.getenv(CLIENT_ID);
        mClientSecret = System.getenv(CLIENT_SECRET);

        if (mClientID == null || mClientSecret == null) {
            throw new EnvironmentVariablesNotSet("Environment variables not set!");
        }
    }
}
