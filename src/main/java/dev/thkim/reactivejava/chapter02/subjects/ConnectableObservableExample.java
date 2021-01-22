package dev.thkim.reactivejava.chapter02.subjects;

import dev.thkim.reactivejava.common.CommonUtils;
import dev.thkim.reactivejava.common.MarbleDiagram;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class ConnectableObservableExample implements MarbleDiagram {

    @Override
    public void marbleDiagram() {
        String[] dt = {"1", "3", "5"};
        Observable<String> balls = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(i -> dt[i])
                .take(dt.length);
        ConnectableObservable<String> source = balls.publish();
        source.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        source.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        source.connect();

        CommonUtils.sleep(250);
        source.subscribe(data -> System.out.println("Subscriber #3 => " + data));
        CommonUtils.sleep(100);
    }

    public static void main(String[] args) {
        ConnectableObservableExample demo = new ConnectableObservableExample();
        demo.marbleDiagram();
    }
}
