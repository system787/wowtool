package system787.wowtool.controller.components;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import system787.wowtool.domain.executor.PostExecutionThread;
import system787.wowtool.domain.executor.ThreadExecutor;

import java.util.concurrent.ThreadFactory;

public class ComputationThread implements PostExecutionThread {

    @Autowired
    ThreadExecutor mThreadExecutor;

    @Override
    public Scheduler getScheduler() {
        return Schedulers.from(mThreadExecutor);
    }
}
