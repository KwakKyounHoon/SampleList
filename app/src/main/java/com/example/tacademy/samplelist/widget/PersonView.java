package com.example.tacademy.samplelist.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tacademy.samplelist.R;
import com.example.tacademy.samplelist.data.Person;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class PersonView extends RelativeLayout implements Checkable {
    public PersonView(Context context) {
        this(context,null);
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    ImageView photoView,checkView,selectView;
    TextView nameView, ageView;

    public void init(){
//        LayoutInflater inflater = LayoutInflater.from(getContext());
//        inflater.inflate(R.layout.view_person, this);
        inflate(getContext(), R.layout.view_person, this);
        photoView = (ImageView)findViewById(R.id.image_photo);
        nameView = (TextView)findViewById(R.id.text_name);
        ageView = (TextView)findViewById(R.id.text_age);
        checkView = (ImageView)findViewById(R.id.image_check);
        selectView = (ImageView)findViewById(R.id.image_select);

        photoView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    mListener.onImageClick(PersonView.this, person);
                }
            }
        });
    }

    Person person;

    public void setPerson(Person person){
        this.person = person;
        nameView.setText(person.getName());
        ageView.setText(""+person.getAge());
        photoView.setImageDrawable(person.getPhoto());
    }

    public Person getPerson(){
        return person;
    }

    boolean isChecked;
    @Override
    public void setChecked(boolean b) {
        if(isChecked != b){
            isChecked = b;
            drawCheck();
        }
    }

    private void drawCheck() {
        if (isChecked) {
            checkView.setImageResource(android.R.drawable.checkbox_on_background);
            selectView.setVisibility(View.VISIBLE);
        } else {
            checkView.setImageResource(android.R.drawable.checkbox_off_background);
            selectView.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked);
    }

    public interface OnImageClickListener{
        public void onImageClick(PersonView personView, Person person);
    }

    OnImageClickListener mListener;

    public void setOnImageClickListener(OnImageClickListener listener){
        mListener = listener;
    }


}
