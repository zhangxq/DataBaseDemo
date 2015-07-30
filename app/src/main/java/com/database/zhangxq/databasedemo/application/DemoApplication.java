package com.database.zhangxq.databasedemo.application;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
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
