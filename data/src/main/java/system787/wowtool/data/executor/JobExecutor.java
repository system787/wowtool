package system787.wowtool.data.executor;

import org.jetbrains.annotations.NotNull;
import system787.wowtool.domain.executor.ThreadExecutor;

import javax.inject.Singleton;

@Singleton
public class JobExecutor implements ThreadExecutor {
    @Override
    public void execute(@NotNull Runnable command) {

    }
}
