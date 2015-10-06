package com.database.zhangxq.databasedemo.api;

import com.database.zhangxq.databasedemo.model.Contributor;
import com.database.zhangxq.databasedemo.model.Music;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by zhangq on 2015/8/22.
 */
public interface TestLocalApi {

    @GET("/getjson.action")
    void getMusics(Callback<List<Music>> callback);
}
