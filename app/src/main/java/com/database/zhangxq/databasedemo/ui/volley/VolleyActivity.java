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
import com.database.zhangxq.databasedemo.model.Contributor;
import com.database.zhangxq.databasedemo.service.TestService;
import com.database.zhangxq.databasedemo.utils.AsyncResponseHandler;
import com.viewinject.ViewHelper;
import com.viewinject.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxq on 15/7/30.
 */

public class VolleyActivity extends Activity {

    private TestService testService;
    private List<Contributor> contributors;

    @ViewInject(R.id.listView)
    ListView listView;

    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        ViewHelper.inject(this);

        testService = new TestService();
        contributors = new ArrayList<Contributor>();
        adapter = new ListViewAdapter();
        listView.setAdapter(adapter);
        getData();
    }

    private void getData() {
        testService.getTestData("square", "retrofit", new AsyncResponseHandler() {
            @Override
            public void onSuccess(Object response) {
                if (response != null) {
                    contributors = (List<Contributor>) response;
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Throwable error, String message, long code) {
                Toast.makeText(VolleyActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    private class ListViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return contributors.size();
        }

        @Override
        public Contributor getItem(int i) {
            return contributors.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(VolleyActivity.this, R.layout.view_contributor_list_item, null);
                viewHolder = new ViewHolder();
                viewHolder.textViewLogin = (TextView) view.findViewById(R.id.textViewLogin);
                viewHolder.textViewContributor = (TextView) view.findViewById(R.id.textViewContributor);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            Contributor contributor = getItem(i);
            viewHolder.textViewLogin.setText(contributor.getLogin());
            viewHolder.textViewContributor.setText(contributor.getContributions() + "");

            return view;
        }

        private class ViewHolder {
            public TextView textViewLogin;
            public TextView textViewContributor;
        }
    }
}
