package system787.wowtool.controller.components.model.mapper;

import system787.wowtool.controller.components.model.TokenResponseModel;
import system787.wowtool.domain.TokenResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TokenResponseMapper {

    public TokenResponseMapper() {
    }

    public TokenResponseModel transform(TokenResponse tokenResponse) {
        if (tokenResponse == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }

        final TokenResponseModel tokenResponseModel
                = new TokenResponseModel(tokenResponse.getAccessToken(),
                tokenResponse.getTokenType(),
                tokenResponse.getExpiresIn(),
                tokenResponse.getTokenTimestamp());

        return tokenResponseModel;
    }

    public Collection<TokenResponseModel> transform(Collection<TokenResponse> domainTokenResponseList) {
        Collection<TokenResponseModel> controllerModelList;

        if (domainTokenResponseList != null && !domainTokenResponseList.isEmpty()) {
            controllerModelList = new ArrayList<>();

            for (TokenResponse tokenResponse : domainTokenResponseList) {
                controllerModelList.add(transform(tokenResponse));
            }
        } else {
            controllerModelList = Collections.emptyList();
        }

        return controllerModelList;
    }

}
