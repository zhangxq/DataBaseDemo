package com.database.zhangxq.databasedemo.ui.testedittext;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.database.zhangxq.databasedemo.R;
import com.viewinject.ViewHelper;
import com.viewinject.annotation.ViewInject;

/**
 * Created by zhangxq on 15/8/5.
 */

public class TestEditTextActivity extends Activity {

    @ViewInject(R.id.spinner)
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_edittext);
        ViewHelper.inject(this);

        String[] items = new String[]{"11111", "22222", "33333", "44444", "55555"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(arrayAdapter);
    }
}
