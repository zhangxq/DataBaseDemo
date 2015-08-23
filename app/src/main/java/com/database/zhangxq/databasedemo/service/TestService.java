package com.database.zhangxq.databasedemo.service;

import com.database.zhangxq.databasedemo.model.Contributor;
import com.database.zhangxq.databasedemo.tools.GlobalTools;
import com.database.zhangxq.databasedemo.utils.ACache;
import com.database.zhangxq.databasedemo.utils.AsyncResponseHandler;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * Created by zhangxq on 15/7/30.
 */
public class TestService {
    public void getTestData(String owner, String repo, final AsyncResponseHandler handler) {
        GlobalTools.getTestApiImpl().contributors(owner, repo, new Callback<List<Contributor>>() {
            @Override
            public void success(List<Contributor> contributors, retrofit.client.Response response) {
                handler.sendSuccessMessage(contributors);
            }

            @Override
            public void failure(RetrofitError error) {
                handler.sendFailureMessage(error, error.getMessage(), 0);
            }
        });
    }
}
