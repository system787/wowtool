package system787.wowtool.controller.config;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import system787.wowtool.controller.components.ComputationThread;
import system787.wowtool.controller.components.model.mapper.TokenResponseMapper;
import system787.wowtool.data.cache.OAuthCache;
import system787.wowtool.data.cache.OAuthCacheImpl;
import system787.wowtool.data.entity.TokenResponseEntity;
import system787.wowtool.data.entity.mapper.TokenResponseEntityDataMapper;
import system787.wowtool.data.executor.JobExecutor;
import system787.wowtool.data.repository.OAuthDataRepository;
import system787.wowtool.domain.executor.PostExecutionThread;
import system787.wowtool.domain.executor.ThreadExecutor;
import system787.wowtool.domain.interactor.GetOAuthTokenUseCase;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    public ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return new JobExecutor();
    }

    @Bean
    public OAuthCache provideOAuthCache(OAuthCacheImpl oAuthCache) {
        return new OAuthCacheImpl();
    }

    @Bean
    public OAuthDataRepository provideOAuthRepository() {
        return new OAuthDataRepository();
    }

    @Bean
    public PostExecutionThread providePostExecutionThread(ComputationThread thread) {
        return thread;
    }

    @Bean
    public TokenResponseMapper provideTokenResponseMapper() {
        return new TokenResponseMapper();
    }

    @Bean
    public ComputationThread provideComputationThread() {
        return new ComputationThread();
    }
}
