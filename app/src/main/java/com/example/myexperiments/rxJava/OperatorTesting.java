package com.example.myexperiments.rxJava;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class OperatorTesting {

    Observable<Integer> observable1 = Observable.range(1, 3).delay(500, TimeUnit.MILLISECONDS);
    Observable<Integer> observable2 = Observable.range(4, 3).delay(1, TimeUnit.SECONDS);
    Observable<Integer> observable3 = Observable.range(7, 3).delay(800, TimeUnit.MILLISECONDS);

    public void simpleOperator() {
//        Observable.just(1, 2, 3, 4, 5, 6)
//        Observable.fromArray(1, 2, 3, 4, 5, 6)
        Observable.range(13, 5)
                .repeat(3)
//                .delay(3, TimeUnit.SECONDS)
                .skip(3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("TAG", "" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void mergeObservable() {
        //to print all observable in asynchronous
        Observable.
                merge(observable1, observable2, observable3).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("TAG", "" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void concatObservable() {
        //to print sequentially all observable synchronous
        Observable.
                concat(observable1, observable2, observable3).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("TAG", "" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void zipObservable() {
        Observable.
                zip(observable1, observable2, new BiFunction<Integer, Integer, String>() {
                    @Override
                    public String apply(Integer integer, Integer integer2) throws Exception {
                        return integer + "-" + integer2;
                    }
                }).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String integer) {
                        Log.e("TAG", "" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
