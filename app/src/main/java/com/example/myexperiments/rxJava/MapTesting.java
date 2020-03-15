package com.example.myexperiments.rxJava;


import android.util.Log;
import io.reactivex.*;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.util.Random;
import java.util.concurrent.TimeUnit;

//todo Node : these all observers needs to be used with CompositeDisposable and cleared after the use

public class MapTesting {

    private String[] names = {"Anand", "Aman", "Abhishek", "Anshu"};
    private User user;
    private String[] addresses = {"Delhi", "Mumbai", "Chennai", "Kolkata"};
    private Random random = new Random();

    public void simpleMapTesting() {
        //Observable<String> myObservable = Observable.just("Hello", "World");
//        Observable<String> myObservable = Observable.fromArray("Hello", "World");
        Observable<User> myObservable = Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                for (String name : names) {
                    user = new User();
                    user.setName(name);
                    emitter.onNext(user);
                }
                if (!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        });

        myObservable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                map(new Function<User, User>() {
                    @Override
                    public User apply(User user) throws Exception {
                        user.setName(user.getName() + "@gmail.com");
                        user.setSex("Male");
                        user.setAddress("Sapient");
                        return user;
                    }
                }).
                subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("TAG", "onSubscribe");
                    }

                    @Override
                    public void onNext(User user) {
                        Log.e("OnNext", "Name : " + user.getName() + "\tSex : " + user.getSex() + "\tAddress : " + user.getAddress());
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

    public void simpleFlatMapTesting() {
        //flatmap testing
        Observable<User> myObservable = Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                for (String s : names) {
                    user = new User();
                    user.setName(s);
                    emitter.onNext(user);
                }
            }
        });

        myObservable
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .flatMap(new Function<User, ObservableSource<User>>() {
                    @Override
                    public ObservableSource<User> apply(User user) throws Exception {
                        return getAddressOfTheUser(user);
                    }
                })
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("TAG", "onSubscribe");
                    }

                    @Override
                    public void onNext(User user) {
                        Log.e("OnNext", "Name : " + user.getName() + "\tAddress : " + user.getAddress());
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

    private Observable<User> getAddressOfTheUser(final User user) {
        return Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                user.setAddress(addresses[random.nextInt(4)]);
                emitter.onNext(user);
                emitter.onComplete();
            }
        });
    }

    public void concateMapTesting() {
        //concat map testing
        Observable<User> userObservable = Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                for (String name : names) {
                    user = new User();
                    user.setName(name);
                    emitter.onNext(user);
                }
                if (!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        });

        userObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .concatMap(new Function<User, ObservableSource<User>>() {
                    @Override
                    public ObservableSource<User> apply(User user) throws Exception {
                        return getAddressFromConcatMap(user);
                    }
                })
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("TAG", "onSubscribe");
                    }

                    @Override
                    public void onNext(User user) {
                        Log.e("onNext", "Name : " + user.getName() + "\tAddress : " + user.getAddress());
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

    private Observable<User> getAddressFromConcatMap(final User user) {
        return Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                if (!emitter.isDisposed()) {
                    user.setAddress(addresses[random.nextInt(4)]);
                    emitter.onNext(user);
                    emitter.onComplete();
                }
            }
        });
    }

    public void switchMapTesting() {
        Observable<User> switchUserObservable = Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                for (String name : names) {
                    user = new User();
                    user.setName(name);
                    Thread.sleep(1000);
                    emitter.onNext(user);
                }
                if (!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        });

        switchUserObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .switchMap(new Function<User, ObservableSource<User>>() {
                    @Override
                    public ObservableSource<User> apply(User user) throws Exception {
                        return Observable.just(user).delay(1, TimeUnit.SECONDS);
                    }
                })
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("TAG", "onSubscribe");
                    }

                    @Override
                    public void onNext(User user) {
                        Log.e("onNext", "Name : " + user.getName() + "\tAddress : " + user.getAddress());
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
}
