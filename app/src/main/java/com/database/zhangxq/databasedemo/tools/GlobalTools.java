package com.database.zhangxq.databasedemo.tools;

import com.database.zhangxq.databasedemo.api.TestApi;
import com.database.zhangxq.databasedemo.api.TestLocalApi;
import com.database.zhangxq.databasedemo.application.DemoApplication;
import com.database.zhangxq.databasedemo.utils.ACache;

import retrofit.RestAdapter;

/**
 * Created by zhangxq on 15/7/30.
 */
public class GlobalTools {

    public static final String BASE_URL = "https://api.github.com";
    public static final String BASE_URL_Local = "http://192.168.1.2:8080/test_server/";

    private static RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(BASE_URL).build();
    private static RestAdapter restAdapterLocal = new RestAdapter.Builder().setEndpoint(BASE_URL_Local).build();

    public static TestApi getTestApiImpl() {
        return restAdapter.create(TestApi.class);
    }
    public static TestLocalApi getTestLocalApiImpl() {
        return restAdapterLocal.create(TestLocalApi.class);
    }
}
