package com.database.zhangxq.databasedemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.database.zhangxq.databasedemo.R;
import com.database.zhangxq.databasedemo.model.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by zhangxq on 2015/6/14.
 */

@EActivity(R.layout.activity_add)
public class AddActivity extends Activity {

    @ViewById
    EditText editTextName;
    @ViewById
    EditText editTextPassword;
    @ViewById
    EditText editTextPhone;

    @AfterViews
    void afterViews() {

    }

    @Click(R.id.buttonAdd)
    void onButtonAddClick() {
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
