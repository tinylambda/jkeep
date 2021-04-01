package rx;

import java.io.File;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxConcatMap {
    public static void main(String[] args) {
        Disposable disposable = Observable.create(new ObservableOnSubscribe<File>() {
            @Override
            public void subscribe(ObservableEmitter<File> emitter) throws Exception {
                File file = new File("/tmp/" + File.separator + "blacklist");
                emitter.onNext(file);
            }
        }).concatMap(new Function<File, ObservableSource<File>>() {
            @Override
            public ObservableSource<File> apply(File file) throws Throwable {
                if (!file.isDirectory()) {
                    return Observable.empty();
                }
                return Observable.fromArray(file.listFiles());
            }
        }).subscribe(new Consumer<File>() {
            @Override
            public void accept(File file) throws Throwable {
                log.info("getPackageNames " + "删除文件夹中已存在的文件");
            }
        });
        log.info("" + disposable.isDisposed());
    }
}
