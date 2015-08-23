package com.database.zhangxq.databasedemo.tools;

import com.database.zhangxq.databasedemo.api.TestApi;
import com.database.zhangxq.databasedemo.application.DemoApplication;
import com.database.zhangxq.databasedemo.utils.ACache;

import retrofit.RestAdapter;

/**
 * Created by zhangxq on 15/7/30.
 */
public class GlobalTools {

    public static final String BASE_URL = "https://api.github.com";
    private static RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(BASE_URL).build();

    private static ACache aCache = ACache.get(DemoApplication.applicationContext);

    public static ACache getACache() {
        return aCache;
    }

    public static TestApi getTestApiImpl() {
        return restAdapter.create(TestApi.class);
    }
}
