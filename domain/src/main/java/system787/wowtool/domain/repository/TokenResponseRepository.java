package system787.wowtool.domain.repository;

import io.reactivex.Observable;
import system787.wowtool.domain.TokenResponse;

public interface TokenResponseRepository {

    Observable<TokenResponse> tokenResponse();
}
