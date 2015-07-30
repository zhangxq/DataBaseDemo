package com.database.zhangxq.databasedemo.tools;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.database.zhangxq.databasedemo.application.DemoApplication;

/**
 * Created by zhangxq on 15/7/30.
 */
public class GlobalTools {

    private static RequestQueue requestQueue;

    /**
     * 获取网络访问队列
     *
     * @return
     */
    public static synchronized RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(DemoApplication.applicationContext);
        }

        return requestQueue;
    }
}
