package com.example.tacademy.samplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class ExpandableListActivity extends AppCompatActivity {
    ExpandableListView listView;
    MyGroupAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);
        listView = (ExpandableListView)findViewById(R.id.expandableListView);
        mAdapter = new MyGroupAdapter();
        listView.setAdapter(mAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(ExpandableListActivity.this, "child click", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        initData();
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5 ; j++) {
                mAdapter.put("group" + i , "child:"+i+","+j);
            }
        }
    }
}
