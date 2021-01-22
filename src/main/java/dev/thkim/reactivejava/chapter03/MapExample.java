package dev.thkim.reactivejava.chapter03;

import dev.thkim.reactivejava.common.Log;
import dev.thkim.reactivejava.common.MarbleDiagram;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MapExample implements MarbleDiagram {

    @Override
    public void marbleDiagram() {
        String[] balls = {"1", "2", "3", "5"};
        Observable<String> source = Observable.fromArray(balls)
                .map(ball -> ball + "<>");
        source.subscribe(Log::i);
    }

    public void mapFunction() {
        Function<String, String> getDiamond = ball -> ball + "<>";
        String[] balls = {"1", "2", "3", "5"};
        Observable<String> source = Observable.fromArray(balls)
                .map(getDiamond);
        source.subscribe(Log::i);
    }

    public void mappingType() {
        Function<String, Integer> ballToIndex = ball -> {
            switch (ball) {
                case "RED": return 1;
                case "YELLOW": return 2;
                case "GREEN": return 3;
                case "BLUE": return 5;
                default: return -1;
            }
        };

        String[] balls = {"RED", "YELLOW", "GREEN", "BLUE"};
        Observable<Integer> source = Observable.fromArray(balls)
                .map(ballToIndex); // 명시적인 타입 변환 없이 바로 사용 가능
        source.subscribe(Log::i);
    }

    public static void main(String[] args) {
        MapExample demo = new MapExample();
        demo.marbleDiagram();
        demo.mapFunction();
        demo.mappingType();
    }

}
