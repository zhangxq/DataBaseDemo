package com.database.zhangxq.databasedemo.ui.testedittext;

import android.app.Activity;
import android.os.Bundle;

import com.database.zhangxq.databasedemo.R;
import com.viewinject.ViewHelper;

/**
 * Created by zhangxq on 15/8/5.
 */

public class TestEditTextActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_edittext);
        ViewHelper.inject(this);
    }
}
