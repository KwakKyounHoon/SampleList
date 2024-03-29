package com.example.tacademy.samplelist.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tacademy.samplelist.R;
import com.example.tacademy.samplelist.data.Person;

/**
 * Created by Tacademy on 2016-07-15.
 */
public class PersonViewHolder extends RecyclerView.ViewHolder {
    ImageView photoView;
    TextView nameView, ageView;
    public PersonViewHolder(View itemView) {
        super(itemView);
        photoView = (ImageView) itemView.findViewById(R.id.image_photo);
        nameView = (TextView)itemView.findViewById(R.id.text_name);
        ageView = (TextView)itemView.findViewById(R.id.text_age);
    }

    Person person;
    public void setPerson(Person person){
        this.person = person;
        photoView.setImageDrawable(person.getPhoto());
        nameView.setText(person.getName());
        ageView.setText(person.getAge()+"");
    }
}
