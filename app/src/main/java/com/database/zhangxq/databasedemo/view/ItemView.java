package com.database.zhangxq.databasedemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.database.zhangxq.databasedemo.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.w3c.dom.Text;


/**
 * Created by zhangxq on 2015/6/14.
 */
@EViewGroup(R.layout.view_item)
public class ItemView extends LinearLayout {

    @ViewById
    TextView textViewName;
    @ViewById
    TextView textViewPassword;
    @ViewById
    TextView textViewPhone;

    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ItemView(Context context) {
        super(context);
    }

    public void setName(String name) {
        textViewName.setText(name);
    }

    public void setPassword(String password) {
        textViewPassword.setText(password);
    }

    public void setPhone(String phone) {
        textViewPhone.setText(phone);
    }
}
