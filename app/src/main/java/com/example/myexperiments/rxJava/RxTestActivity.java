package com.example.myexperiments.rxJava;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myexperiments.R;
import io.reactivex.*;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RxTestActivity extends AppCompatActivity {

    private RxSimpleTesting mRxSimpleTesting;
    private MapTesting mapTesting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_test);

        //Simple Operations
        mRxSimpleTesting = new RxSimpleTesting();
//        mRxSimpleTesting.startRxTest();
//        mRxSimpleTesting.filterTheObservable();
//        mRxSimpleTesting.performOperationWithMultipleOperator();

        mapTesting = new MapTesting();
//        mapTesting.simpleMapTesting();
//        mapTesting.simpleFlatMapTesting();
//        mapTesting.concateMapTesting();
//        mapTesting.switchMapTesting();


//        PublishSubject<Integer> publishSubject = PublishSubject.create();
//        publishSubject.subscribe(getFirstObserver());
//        publishSubject.onNext(1);
//        publishSubject.onNext(3);
//        publishSubject.onNext(4);
//
//        publishSubject.subscribe(getSecondObserver());
//        publishSubject.onNext(5);
//        publishSubject.onComplete();

        Observable.just(1, 3, 4, 5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("TAG - accept", ""+integer);
                    }
                })
                .subscribe();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mRxSimpleTesting != null) {
            mRxSimpleTesting.cleanUp();
        }
    }

    public Observer<Integer> getFirstObserver() {
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("TAG1", "onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e("TAG1", integer + "");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("TAG1", "onError");
            }

            @Override
            public void onComplete() {
                Log.e("TAG1", "onComplete");
            }
        };
    }

    public Observer<Integer> getSecondObserver() {
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("TAG", "onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e("TAG", integer + "");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("TAG", "onError");
            }

            @Override
            public void onComplete() {
                Log.e("TAG", "onComplete");
            }
        };
    }
}
