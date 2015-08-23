package com.database.zhangxq.databasedemo.api;

import com.database.zhangxq.databasedemo.model.Contributor;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by zhangq on 2015/8/22.
 */
public interface TestApi {

    @GET("/repos/{owner}/{repo}/contributors")
    void contributors(@Path("owner") String owner, @Path("repo") String repo, Callback<List<Contributor>> callback);
}
