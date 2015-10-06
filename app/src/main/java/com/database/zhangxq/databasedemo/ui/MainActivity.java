package com.database.zhangxq.databasedemo.ui;

import android.app.Activity;
import android.content.Intent;

import com.database.zhangxq.databasedemo.R;
import com.database.zhangxq.databasedemo.ui.sugerrecorddemo.SugerRecordActivity_;
import com.database.zhangxq.databasedemo.ui.testedittext.TestEditTextActivity_;
import com.database.zhangxq.databasedemo.ui.volley.LocalDataActivity;
import com.database.zhangxq.databasedemo.ui.volley.LocalDataActivity_;
import com.database.zhangxq.databasedemo.ui.volley.VolleyActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    @AfterViews
    void afterViews() {

    }

    @Click(R.id.buttonSugerRecord)
    void onTextViewRightClick() {
        Intent intent = new Intent(this, SugerRecordActivity_.class);
        startActivity(intent);
    }

    @Click(R.id.buttonVolley)
    void onVolleyClick() {
        Intent intent = new Intent(this, VolleyActivity_.class);
        startActivity(intent);
    }

    @Click(R.id.buttonEditTest)
    void onEditTestClick() {
        Intent intent = new Intent(this, TestEditTextActivity_.class);
        startActivity(intent);
    }

    @Click(R.id.buttonLocalDataTest)
    void onLocalDataClick() {
        Intent intent = new Intent(this, LocalDataActivity_.class);
        startActivity(intent);
    }
}

