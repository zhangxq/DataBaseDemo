package com.database.zhangxq.databasedemo.service;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.database.zhangxq.databasedemo.application.DemoApplication;
import com.database.zhangxq.databasedemo.tools.GlobalTools;
import com.database.zhangxq.databasedemo.utils.AsyncResponseHandler;

import org.androidannotations.api.BackgroundExecutor;
import org.json.JSONObject;

/**
 * Created by zhangxq on 15/7/30.
 */
public class TestService {

    public void getTestData(final AsyncResponseHandler handler) {
        StringRequest stringRequest = new StringRequest("http://www.baidu.com",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        handler.sendSuccessMessage(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handler.sendFailureMessage(error, "网络访问失败", 0);
            }
        });
        GlobalTools.getRequestQueue().add(stringRequest);
    }
}
