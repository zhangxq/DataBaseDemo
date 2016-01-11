package com.database.zhangxq.databasedemo.service;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.database.zhangxq.databasedemo.application.DemoApplication;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxq on 16/1/6.
 */
public class VolleyService {
    public void getDate() {
        RequestQueue requestQueue = Volley.newRequestQueue(DemoApplication.applicationContext);
        String urls = "http://192.168.1.8:8080/rest/materialTagId/generate/" + 111;
//                String urls="http://114.80.129.120:615/RMESCore/rest/injectionController/findInjectionInventories/2015-12-26%207:30/2015-12-30%207:30";
        JsonRequest<JSONObject> request = new JsonObjectRequest(urls, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("response", "response -> " + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", "error -> " + error.toString());
            }
        });
        //设置取消取消http请求标签 Activity的生命周期中的onStiop()中调用

        requestQueue.add(request);
    }
}
