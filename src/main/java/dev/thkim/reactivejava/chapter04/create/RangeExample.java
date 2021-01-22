package dev.thkim.reactivejava.chapter04.create;

import dev.thkim.reactivejava.common.CommonUtils;
import dev.thkim.reactivejava.common.Log;
import io.reactivex.Observable;

public class RangeExample {

    public void forLoop() {
        Observable<Integer> source = Observable.range(1, 10)
                .filter(number -> number % 2 == 0);
        source.subscribe(Log::i);
        CommonUtils.exampleComplete();
    }

    public static void main(String[] args) {
        RangeExample demo = new RangeExample();
        demo.forLoop();
    }

}

