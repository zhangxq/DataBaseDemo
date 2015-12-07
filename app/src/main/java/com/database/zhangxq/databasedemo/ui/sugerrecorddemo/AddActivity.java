package com.database.zhangxq.databasedemo.ui.sugerrecorddemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.database.zhangxq.databasedemo.R;
import com.database.zhangxq.databasedemo.model.User;
import com.viewinject.ViewHelper;
import com.viewinject.annotation.ViewInject;
import com.viewinject.annotation.event.OnClick;

/**
 * Created by zhangxq on 2015/6/14.
 */

public class AddActivity extends Activity implements View.OnClickListener {

    @ViewInject(R.id.editTextName)
    EditText editTextName;
    @ViewInject(R.id.editTextPassword)
    EditText editTextPassword;
    @ViewInject(R.id.editTextPhone)
    EditText editTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ViewHelper.inject(this);
    }

    @OnClick(R.id.buttonAdd)
    public void onClick(View v) {
        String name = editTextName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();

        User user = new User(name, password, phone);
        user.save();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
