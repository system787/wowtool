package system787.wowtool.controller.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import system787.wowtool.data.net.config.AppConfig;
import system787.wowtool.data.net.config.AppConfigMapper;
import system787.wowtool.data.net.oauth.OauthApi;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Map;

@Service
public class ApiComponentsImpl implements ApiComponent {

    @Autowired
    OauthApi mOauthApi;

    AppConfig mAppConfig = AppConfigMapper.mapAppConfig();

    private RestTemplate mRestTemplate = new RestTemplate();

    @Override
    public <T> T apiGetData(String path,
                            Map<String, String> params,
                            Class<T> classOfT) throws IOException, URISyntaxException {

        return apiGetData(path, params, classOfT, true);
    }

    @Override
    public <T> T apiGetData(String path,
                            Map<String, String> params,
                            Class<T> classOfT,
                            Boolean headerRequired) throws IOException, URISyntaxException {

        String token = mOauthApi.getToken();

        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUri(mAppConfig.getBaseURL().toURI())
                .path(path);

        params.forEach(uriBuilder::queryParam);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        if (headerRequired) {
            headers.set("Authorization", String.format("Bearer %s", token));
        } else {
            uriBuilder.queryParam("access_token", token);
        }

        URI uri = uriBuilder.build().toUri();

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<T> result = mRestTemplate.exchange(uri, HttpMethod.GET, entity, classOfT);

        return result.getBody();
    }
}
