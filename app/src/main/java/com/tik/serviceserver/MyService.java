package com.tik.serviceserver;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

public class MyService extends Service {

    private MyAIDLService.Stub mBinder = new MyAIDLService.Stub() {
        @Override
        public int plus(int a, int b) throws RemoteException {
            System.out.println("通过aidl调用plus方法成功");
            return a + b;
        }

        @Override
        public void hello(String name) throws RemoteException {
            System.out.println("通过aidl调用hello方法成功");
            System.out.println("hello " + name);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("执行了onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("执行了onStartCommand()方法");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("执行了onUnbind()方法");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("执行了onDestroy()方法");
    }

}
