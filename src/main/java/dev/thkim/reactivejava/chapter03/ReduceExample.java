package dev.thkim.reactivejava.chapter03;

import dev.thkim.reactivejava.common.MarbleDiagram;
import io.reactivex.Maybe;
import io.reactivex.Observable;

public class ReduceExample implements MarbleDiagram {


    @Override
    public void marbleDiagram() {
        String[] balls = {"1", "3", "5"};
        Maybe<String> source = Observable.fromArray(balls)
                .reduce((ball1, ball2) -> ball2 + "(" + ball1 + ")");
        source.subscribe(System.out::println);
    }

    public void biFunction() {

    }

    public static void main(String[] args) {
        ReduceExample demo = new ReduceExample();
        demo.marbleDiagram();
    }
}
