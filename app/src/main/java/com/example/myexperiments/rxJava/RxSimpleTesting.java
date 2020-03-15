package com.example.myexperiments.rxJava;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RxSimpleTesting {
    private Disposable disposable;
    private CompositeDisposable compositeDisposable;

    public RxSimpleTesting() {
        compositeDisposable = new CompositeDisposable();
    }

    //simple example
    public void startRxTest() {
        Observable<String> myObservable = Observable.just("Anand", "Kumar", "Jha");
        myObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                        Log.e("TAG", "onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("onNext", s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG", "onComplete");
                    }
                });
    }

    //filter exmaple
//        TAG: onSubscribe
//        onNext: KUMAR
//        onNext: KUMAR1
//        onNext: KUMAR
//        TAG: onComplete
    public void filterTheObservable() {
        Observable<String> observable = Observable.fromArray("Anand", "Kumar", "Jha", "Anand1", "Kumar1", "Jha1", "Anand3", "Kumar", "Jha");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return s.startsWith("K");
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("onNext", s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG", "onComplete");
                    }
                });
    }

    public void performOperationWithMultipleOperator() {
        //multiple observer
        Observable<String> observable = Observable.fromArray("Anand", "Kumar", "Jha", "Anand1", "Kumar1", "Jha1", "Anand3", "Kumar", "Jha");
        compositeDisposable.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return s.startsWith("K");
                    }
                })
                .subscribeWith(new DisposableObserver<String>() {
                    @Override
                    public void onNext(String s) {
                        Log.e("onNext", s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG", "onComplete");
                    }
                }));

        //filter example with map
        Observable<String> observable1 = Observable.fromArray("Anand", "Kumar", "Jha", "Anand1", "Kumar1", "Jha1", "Anand3", "Kumar", "Jha");
        compositeDisposable.add(observable1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return s.startsWith("A");
                    }
                }).map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return s.toUpperCase();
                    }
                })
                .subscribeWith(new DisposableObserver<String>() {
                    @Override
                    public void onNext(String s) {
                        Log.e("onNext", s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG", "onComplete");
                    }
                }));
    }

    public void cleanUp() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }

        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
        }
    }
}
