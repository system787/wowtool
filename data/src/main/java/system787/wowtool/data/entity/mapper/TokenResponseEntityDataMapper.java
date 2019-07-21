package system787.wowtool.data.entity.mapper;

import system787.wowtool.data.entity.TokenResponseEntity;
import system787.wowtool.domain.TokenResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Singleton
public class TokenResponseEntityDataMapper {

    @Inject
    TokenResponseEntityDataMapper() {}

    public TokenResponse transform(TokenResponseEntity entity) {
        if (entity != null) {
            TokenResponse tokenResponse = new TokenResponse(
                    entity.getAccessToken(),
                    entity.getTokenType(),
                    entity.getExpiresIn(),
                    entity.getTokenTimestamp());

            return tokenResponse;
        }

        return null;
    }

    public List<TokenResponse> transformAll(Collection<TokenResponseEntity> entityCollection) {
        List<TokenResponse> tokenResponses = new ArrayList<>();

        for (TokenResponseEntity entity : entityCollection) {
            TokenResponse response = transform(entity);

            if (response != null) {
                tokenResponses.add(response);
            }
        }

        return tokenResponses;
    }
}
