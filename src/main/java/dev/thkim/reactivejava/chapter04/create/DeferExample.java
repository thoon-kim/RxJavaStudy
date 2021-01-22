package dev.thkim.reactivejava.chapter04.create;

import dev.thkim.reactivejava.common.CommonUtils;
import dev.thkim.reactivejava.common.Log;
import dev.thkim.reactivejava.common.MarbleDiagram;
import dev.thkim.reactivejava.common.Shape;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;

public class DeferExample implements MarbleDiagram {

    Iterator<String> colors = Arrays.asList("1", "3", "5", "6").iterator();

    @Override
    public void marbleDiagram() {
        Callable<Observable<String>> supplier = () -> getObservable();
        Observable<String> source = Observable.defer(supplier);

        source.subscribe(val -> Log.i("Subscriber #1: " + val));
        source.subscribe(val -> Log.i("Subscriber #2: " + val));
        CommonUtils.exampleComplete();
    }

    private Observable<String> getObservable() {
        if (colors.hasNext()) {
            String color = colors.next();
            return Observable.just(
                    Shape.getString(color, Shape.BALL),
                    Shape.getString(color, Shape.RECTANGLE),
                    Shape.getString(color, Shape.PENTAGON)
            );
        }

        return Observable.empty();
    }

    public void notDeferred() {
        Observable<String> source = getObservable();

        source.subscribe(val -> Log.i("Subscriber #1:" + val));
        source.subscribe(val -> Log.i("Subscriber #2:" + val));
        CommonUtils.exampleComplete();
    }

    public static void main(String[] args) {
        DeferExample demo = new DeferExample();
        demo.marbleDiagram();
        demo.notDeferred();
    }
}
