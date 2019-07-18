package system787.wowtool.data.executor;

import io.reactivex.annotations.NonNull;
import org.jetbrains.annotations.NotNull;
import system787.wowtool.domain.executor.ThreadExecutor;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Singleton
public class JobExecutor implements ThreadExecutor {
    private final ThreadPoolExecutor mThreadPoolExecutor;

    @Inject
    JobExecutor() {
        this.mThreadPoolExecutor = new ThreadPoolExecutor(3, 6, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new JobThreadFactory());
    }

    @Override
    public void execute(@NotNull Runnable command) {
        this.mThreadPoolExecutor.execute(command);
    }

    private static class JobThreadFactory implements ThreadFactory {
        private int counter = 0;

        @Override
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "wowtool_" + counter++);
        }
    }
}
