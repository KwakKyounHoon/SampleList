package com.example.tacademy.samplelist;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.tacademy.samplelist.data.Person;
import com.example.tacademy.samplelist.widget.PersonView;

public class MainActivity extends AppCompatActivity {

    PersonView personView;
    ImageView pictureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pictureView = (ImageView)findViewById(R.id.image_picture);
        pictureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pictureView.setVisibility(View.GONE);
            }
        });

        personView = (PersonView)findViewById(R.id.person_view);
        personView.setOnImageClickListener(new PersonView.OnImageClickListener() {
            @Override
            public void onImageClick(PersonView personView, Person person) {
                pictureView.setImageDrawable(person.getPhoto());
                pictureView.setVisibility(View.VISIBLE);
            }
        });

        initData();
    }

    public void initData(){
        Drawable image = ContextCompat.getDrawable(this ,R.drawable.sample_0);

        Person person = new Person("곽견훈", 25, image);

        personView.setPerson(person);


    }
}
