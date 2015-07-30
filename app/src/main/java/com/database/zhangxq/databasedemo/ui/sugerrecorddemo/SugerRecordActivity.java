package com.database.zhangxq.databasedemo.ui.sugerrecorddemo;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.database.zhangxq.databasedemo.R;
import com.database.zhangxq.databasedemo.model.User;
import com.database.zhangxq.databasedemo.view.ItemView;
import com.database.zhangxq.databasedemo.view.ItemView_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_suger_record)
public class SugerRecordActivity extends Activity{
    @ViewById
    ListView listView;
    private ListAdapter listAdapter;
    private List<User> users;

    @AfterViews
    void afterViews() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        users = new ArrayList<User>();
        users.addAll(User.listAll(User.class));

        listAdapter = new ListAdapter();
        listView.setAdapter(listAdapter);
    }

    @Click(R.id.textViewRight)
    void onTextViewRightClick() {
        Intent intent = new Intent(this, AddActivity_.class);
        startActivity(intent);
    }

    private class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return users.size();
        }

        @Override
        public User getItem(int i) {
            return users.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ItemView itemView = null;
            if (view == null) {
                itemView = ItemView_.build(SugerRecordActivity.this);
            } else {
                itemView = (ItemView) view;
            }

            User user = getItem(i);
            itemView.setName(user.getUserName());
            itemView.setPassword(user.getPassword());
            itemView.setPhone(user.getPhone());

            return itemView;
        }
    }
}
