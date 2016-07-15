package com.example.tacademy.samplelist;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.tacademy.samplelist.data.Person;
import com.example.tacademy.samplelist.widget.PersonView;

import java.util.Random;

public class CustomListActivity extends AppCompatActivity  {

    ListView listView;
    PersonAdapter mAdapter;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        listView = (ListView)findViewById(R.id.listView3);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        imageView = (ImageView)findViewById(R.id.image_center);
        mAdapter = new PersonAdapter();
        listView.setAdapter(mAdapter);

        mAdapter.setOnAdapterImageClickListener(new PersonAdapter.OnAdapterImageClickListener() {
            @Override
            public void onAdapterImageClick(PersonAdapter adapter, PersonView view, Person person) {
                imageView.setImageDrawable(person.getPhoto());
                imageView.setVisibility(View.VISIBLE);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(View.GONE);
            }
        });
        initData();
    }



    int[] resIds = {R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2,
            R.drawable.sample_3,R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6,R.drawable.sample_7};

    private void initData() {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            Person p = new Person();
            p.setName("name " + i);
            p.setAge(20 + r.nextInt(30));
            p.setPhoto(ContextCompat.getDrawable(this, resIds[i % resIds.length]));
            mAdapter.add(p);
        }
    }
}

