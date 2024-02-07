package fr.epita.assistants.scheduler;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

public class MyTask<INPUT_TYPE, RETURN_TYPE> implements Task<RETURN_TYPE> {

    private CompletableFuture<RETURN_TYPE> cpl_ftr;

    public MyTask(CompletableFuture<RETURN_TYPE> _cpl_ftr) {
        this.cpl_ftr = _cpl_ftr;
    }

    static <RETURN_TYPE> Task<RETURN_TYPE> of(Supplier<RETURN_TYPE> actionSupplier) {
        return new MyTask<>(CompletableFuture.supplyAsync(actionSupplier));
    }

    @Override
    public CompletableFuture<RETURN_TYPE> build() {
        return cpl_ftr;
    }

    @Override
    public Task<RETURN_TYPE> onErrorRecoverWith(Function<Throwable, RETURN_TYPE> recoveryFunction) {
        return new MyTask<>(cpl_ftr.exceptionallyAsync(recoveryFunction));
    }

    @Override
    public <NEW_RETURN_TYPE> Task<NEW_RETURN_TYPE> andThenDo(Function<RETURN_TYPE, NEW_RETURN_TYPE> action) {
        return new MyTask<>(cpl_ftr.thenApply(action));
    }

    @Override
    public Task<RETURN_TYPE> andThenWait(long number, TimeUnit timeUnit) {
        return new MyTask<>(cpl_ftr.thenApply((r) ->
                {
                    try {
                        CompletableFuture.runAsync(() ->
                                {
                                },
                                CompletableFuture.delayedExecutor(number, timeUnit)).get();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                    return r;
                }

        ));
    }
}
