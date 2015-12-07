package com.database.zhangxq.databasedemo.ui.volley;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.database.zhangxq.databasedemo.R;
import com.database.zhangxq.databasedemo.model.Music;
import com.database.zhangxq.databasedemo.service.TestService;
import com.database.zhangxq.databasedemo.utils.AsyncResponseHandler;
import com.viewinject.ViewHelper;
import com.viewinject.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

public class LocalDataActivity extends Activity{
    private TestService testService;

    @ViewInject(R.id.listView)
    ListView listView;
    private ListAdapter adapter;
    private List<Music> musics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_data);
        ViewHelper.inject(this);

        testService = new TestService();
        musics = new ArrayList<Music>();
        adapter = new ListAdapter();
        listView.setAdapter(adapter);
        getData();
    }

    private void getData() {
        testService.getMusics(new AsyncResponseHandler() {
            @Override
            public void onSuccess(Object response) {
                if (response != null) {
                    musics = (List<Music>) response;
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Throwable error, String message, long code) {
                Toast.makeText(LocalDataActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    private class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return musics.size();
        }

        @Override
        public Music getItem(int i) {
            return musics.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(LocalDataActivity.this, R.layout.view_database_list_item, null);
                viewHolder = new ViewHolder();
                viewHolder.textViewName = (TextView) view.findViewById(R.id.textViewName);
                viewHolder.textViewPassword = (TextView) view.findViewById(R.id.textViewPassword);
                viewHolder.textViewPhone = (TextView) view.findViewById(R.id.textViewPassword);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            Music user = getItem(i);
            viewHolder.textViewName.setText(user.getName());
            viewHolder.textViewPassword.setText(user.getTime());
            viewHolder.textViewPhone.setText(user.getAuthor());

            return view;
        }

        private class ViewHolder {
            public TextView textViewName;
            public TextView textViewPassword;
            public TextView textViewPhone;
        }
    }
}
