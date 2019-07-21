package system787.wowtool.domain.interactor;

import io.reactivex.Observable;
import system787.wowtool.domain.TokenResponse;
import system787.wowtool.domain.executor.PostExecutionThread;
import system787.wowtool.domain.executor.ThreadExecutor;
import system787.wowtool.domain.net.OAuthApi;

import javax.inject.Inject;

public class GetOAuthTokenUseCase extends UseCase<TokenResponse, String> {

    private final OAuthApi mApiConnection;

    @Inject
    public GetOAuthTokenUseCase(OAuthApi mApiConnection, ThreadExecutor threadExecutor,
                                PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.mApiConnection = mApiConnection;
    }

    @Override
    Observable<TokenResponse> buildUseCaseObservable(String encodedCredentials) {
        return this.mApiConnection.tokenResponse(encodedCredentials);
    }

}
