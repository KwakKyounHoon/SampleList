package com.example.tacademy.samplelist;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tacademy.samplelist.data.Person;

import java.util.Random;

public class RecyclerActivity extends AppCompatActivity {
    RecyclePersonAdapter mAdapter;
    RecyclerView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        listview = (RecyclerView) findViewById(R.id.rv_list);
        mAdapter = new RecyclePersonAdapter();
        listview.setAdapter(mAdapter);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        GridLayoutManager manager = new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false);
        listview.setLayoutManager(manager);
        initData();
    }

    int[] resIds = {R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2,
            R.drawable.sample_3, R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7};

    private void initData() {
        Random r = new Random();
        for (int i = 0; i < 40; i++) {
            Person p = new Person();
            p.setName("name " + i);
            p.setAge(20 + r.nextInt(30));
            p.setPhoto(ContextCompat.getDrawable(this, resIds[i % resIds.length]));
            mAdapter.add(p);
        }
    }
}
