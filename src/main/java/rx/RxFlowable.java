package rx;

import java.util.concurrent.TimeUnit;

import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxFlowable {
    public static void main(String[] args) throws InterruptedException {
        Flowable.create((FlowableOnSubscribe<String>) emitter -> {
            for (int i=0; i<200; i++) {
                emitter.onNext("str" + i);
            }
        }, BackpressureStrategy.ERROR)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new FlowableSubscriber<String>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        log.warn("Flowable" + " onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        log.warn("Flowable" + " s: " + s);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        log.warn("Flowable " + "error:" + throwable.toString());
                    }

                    @Override
                    public void onComplete() {
                        log.warn("Flowable" + " onComplete");
                    }
                });
        TimeUnit.SECONDS.sleep(10);
    }
}
