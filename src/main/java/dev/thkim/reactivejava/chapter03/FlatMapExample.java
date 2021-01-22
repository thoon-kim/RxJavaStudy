package dev.thkim.reactivejava.chapter03;

import dev.thkim.reactivejava.common.CommonUtils;
import dev.thkim.reactivejava.common.Log;
import dev.thkim.reactivejava.common.MarbleDiagram;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

public class FlatMapExample implements MarbleDiagram {

    @Override
    public void marbleDiagram() {
        Function<String, Observable<String>> getDoubleDiamonds = ball -> Observable.just(ball + "<>", ball + "<>");

        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable.fromArray(balls)
                .flatMap(getDoubleDiamonds); // 명시적인 타입 변환 없이 바로 사용 가능
        source.subscribe(Log::i);
    }

    public void biFunction() {
        BiFunction<String, String, String> mergeBalls =
                (ball1, ball2) -> ball2 + "(" + ball1 + ")";

        String[] balls = {"RED", "GREEN", "BLUE"};
        Maybe<String> source = Observable.fromArray(balls)
                .reduce(mergeBalls);
        source.subscribe(System.out::println);
        CommonUtils.exampleComplete();
    }

    public static void main(String[] args) {
        FlatMapExample demo = new FlatMapExample();
        demo.marbleDiagram();
        demo.biFunction();
    }
}
