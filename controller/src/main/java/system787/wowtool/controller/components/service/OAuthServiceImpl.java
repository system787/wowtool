package system787.wowtool.controller.components.service;

import com.google.common.flogger.FluentLogger;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system787.wowtool.controller.components.model.TokenResponseModel;
import system787.wowtool.controller.components.model.mapper.TokenResponseMapper;
import system787.wowtool.data.repository.OAuthDataRepository;
import system787.wowtool.domain.TokenResponse;
import system787.wowtool.domain.executor.PostExecutionThread;
import system787.wowtool.domain.executor.ThreadExecutor;
import system787.wowtool.domain.interactor.DefaultObserver;
import system787.wowtool.domain.interactor.GetOAuthTokenUseCase;

@Service
public class OAuthServiceImpl implements OAuthService {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    GetOAuthTokenUseCase mTokenUseCase;

    @Autowired
    OAuthDataRepository mOAuthDataRepository;

    @Autowired
    TokenResponseMapper mTokenResponseMapper;

    @Autowired
    PostExecutionThread mPostExecutionThread;

    @Autowired
    ThreadExecutor mThreadExecutor;

    public OAuthServiceImpl() {
        mTokenUseCase = new GetOAuthTokenUseCase(mOAuthDataRepository,
                mThreadExecutor, mPostExecutionThread);
    }

    @Override
    public void getNewToken(String encodedCredentials) {
        this.mTokenUseCase.execute(new TokenResponseObserver(), encodedCredentials);
    }

    @Override
    public void getCachedToken() {

    }

    @Override
    public void delete() {

    }

    @Override
    public boolean exists() {
        return false;
    }

    private void updateTokenStatus(TokenResponse token) {
        final TokenResponseModel tokenResponseModel
                = this.mTokenResponseMapper.transform(token);

        logger.atInfo().log("Token retrieved: " + tokenResponseModel.toString());
    }

    private final class TokenResponseObserver extends DefaultObserver<TokenResponse> {
        @Override
        public void onNext(TokenResponse tokenResponse) {
            super.onNext(tokenResponse);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }
    }
}
