package com.example.myexperiments.service_testing.aidl_example;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.example.myexperiments.IMyAidlInterface;

public class MyAidlService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final IMyAidlInterface.Stub binder = new IMyAidlInterface.Stub() {


        @Override
        public int add(int a, int b) throws RemoteException {
            return a+b;
        }

        @Override
        public String getMyName() throws RemoteException {
            return "Anand Kumar Jha";
        }
    };
}
