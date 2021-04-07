package concurrent;


import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class ConcurrentListenableFuture {
    public static void usingListenableFuture() throws InterruptedException {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(8));
        for (int i=0; i<10; i++) {
            ListenableFuture<Integer> future = service.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws InterruptedException {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    return 100;
                }
            });
            Futures.addCallback(future, new FutureCallback<Integer>() {
                @Override
                public void onSuccess(@Nullable Integer result) {
                    System.out.println("done: " + result);
                }

                @Override
                public void onFailure(Throwable t) {
                    System.out.println(t);
                }
            }, service);
        }
        service.awaitTermination(10, TimeUnit.SECONDS);
        service.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        usingListenableFuture();
    }
}
