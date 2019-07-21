package system787.wowtool.controller.components.controller;

import com.google.common.flogger.FluentLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system787.wowtool.controller.components.service.OAuthServiceImpl;
import system787.wowtool.controller.config.EnvConfig;

import java.nio.charset.Charset;
import java.util.Base64;

@RestController
public class OAuthController {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    @Autowired
    EnvConfig mEnvConfig;

    @RequestMapping("/oauth")
    public String testAuthentication() {
        String encodedCredentials = Base64.getEncoder()
                .encodeToString(String.format("%s:%s", mEnvConfig.getClientId(), mEnvConfig.getClientSecret())
                .getBytes(Charset.forName("UTF-8")));

        OAuthServiceImpl oAuthService = new OAuthServiceImpl();

        oAuthService.getNewToken(encodedCredentials);

        return "123";
    }

}
