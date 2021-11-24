package rx;


import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxInterval {
    public static void main(String[] args) throws Exception {
        Observable.interval(3000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        log.info("tag {}", "start");
                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {
                        log.info("tag {}", "onNext: " + aLong);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        log.info("tag {}", "error: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        log.info("tag {}", "onComplete");
                    }
                });
        TimeUnit.SECONDS.sleep(10);
    }
}
