package com.database.zhangxq.databasedemo.application;

import android.content.Context;

import com.orm.SugarApp;

/**
 * Created by zhangxq on 2015/6/14.
 */
public class DemoApplication extends SugarApp {
    public static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
    }
}
