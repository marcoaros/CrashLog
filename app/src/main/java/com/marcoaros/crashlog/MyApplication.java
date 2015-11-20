package com.marcoaros.crashlog;

import android.app.Application;

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         *  启动异常捕获线程
         */
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler());
    }
}
