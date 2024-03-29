package com.example.tacademy.samplelist.widget;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tacademy.samplelist.R;
import com.example.tacademy.samplelist.data.Movie;

/**
 * Created by Tacademy on 2016-07-15.
 */
public class MovieView extends RelativeLayout{
    public MovieView(Context context) {
        super(context);
        initData();
    }

    ImageView pictureView;
    TextView titleView, yearView;

    private void initData() {
        inflate(getContext(), R.layout.view_movie, this);
        pictureView = (ImageView)findViewById(R.id.image_picture);
        titleView = (TextView)findViewById(R.id.text_title);
        yearView = (TextView)findViewById(R.id.text_year);
    }

    Movie movie;

    public void setMovie(Movie movie){
        this.movie = movie;
        pictureView.setImageDrawable(movie.picture);
        titleView.setText(movie.title);
        yearView.setText(movie.year);
    }

    public Movie getMovie(){return  movie;}
}
