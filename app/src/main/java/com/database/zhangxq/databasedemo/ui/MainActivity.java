package com.database.zhangxq.databasedemo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.database.zhangxq.databasedemo.R;
import com.database.zhangxq.databasedemo.ui.sugerrecorddemo.SugerRecordActivity;
import com.database.zhangxq.databasedemo.ui.testedittext.TestEditTextActivity;
import com.database.zhangxq.databasedemo.ui.volley.LocalDataActivity;
import com.database.zhangxq.databasedemo.ui.volley.VolleyActivity;
import com.viewinject.ViewHelper;
import com.viewinject.annotation.event.OnClick;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewHelper.inject(this);
    }

    @OnClick(value = {R.id.buttonSugerRecord, R.id.buttonVolley, R.id.buttonEditTest, R.id.buttonLocalDataTest})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSugerRecord:
                Intent intentSugerRecord = new Intent(this, SugerRecordActivity.class);
                startActivity(intentSugerRecord);
                break;
            case R.id.buttonVolley:
                Intent intentVolley = new Intent(this, VolleyActivity.class);
                startActivity(intentVolley);
                break;
            case R.id.buttonEditTest:
                Intent intentEditTest = new Intent(this, TestEditTextActivity.class);
                startActivity(intentEditTest);
                break;
            case R.id.buttonLocalDataTest:
                Intent intentLocalDataTest = new Intent(this, LocalDataActivity.class);
                startActivity(intentLocalDataTest);
                break;
            default:
                break;
        }
    }
}

