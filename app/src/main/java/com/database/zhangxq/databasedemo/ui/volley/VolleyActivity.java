package com.database.zhangxq.databasedemo.ui.volley;

import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

import com.database.zhangxq.databasedemo.R;
import com.database.zhangxq.databasedemo.service.TestService;
import com.database.zhangxq.databasedemo.utils.AsyncResponseHandler;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by zhangxq on 15/7/30.
 */
@EActivity(R.layout.activity_volley)
public class VolleyActivity extends Activity {
    private TestService testService;

    @ViewById
    TextView textView;

    @AfterViews
    void afterViews() {
        testService = new TestService();
        getData();
    }

    private void getData() {
        testService.getTestData(new AsyncResponseHandler() {
            @Override
            public void onSuccess(Object response) {
                String data = (String) response;
                textView.setText(data);
            }

            @Override
            public void onFailure(Throwable error, String message, long code) {
                Toast.makeText(VolleyActivity.this, message, Toast.LENGTH_LONG).show();
            }
        }, this);
    }
}
