package rx;

import java.io.File;
import java.util.Objects;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxConcatMap {
    public static void main(String[] args) {
        Disposable disposable = Observable.create((ObservableOnSubscribe<File>) emitter -> {
            File file = new File("/tmp/" + File.separator + "blacklist");
            emitter.onNext(file);
        }).concatMap((Function<File, ObservableSource<File>>) file -> {
            if (!file.isDirectory()) {
                return Observable.empty();
            }
            return Observable.fromArray(Objects.requireNonNull(file.listFiles()));
        }).subscribe(file -> log.info("getPackageNames " + "删除文件夹中已存在的文件"));
        log.info("" + disposable.isDisposed());
    }
}
