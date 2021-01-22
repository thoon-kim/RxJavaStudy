package dev.thkim.reactivejava.chapter04.create;

import dev.thkim.reactivejava.common.CommonUtils;
import dev.thkim.reactivejava.common.Log;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class IntervalRangeExample {

    public void printNumbers() {
        Observable<Long> source = Observable.intervalRange(1, 5, 100L, 100L, TimeUnit.MILLISECONDS);
        source.subscribe(Log::i);
        CommonUtils.sleep(1000);
        CommonUtils.exampleComplete();
    }

    public void makeWithInterval() {
        Observable<Long> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(val -> val + 1)
                .take(5);
        source.subscribe(Log::i);
        CommonUtils.sleep(1000);
        CommonUtils.exampleComplete();
    }

    public static void main(String[] args) {
        IntervalRangeExample demo = new IntervalRangeExample();
        demo.printNumbers();
        demo.makeWithInterval();
    }
}
