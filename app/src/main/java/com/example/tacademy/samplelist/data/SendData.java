package com.example.tacademy.samplelist.data;

import android.graphics.drawable.Drawable;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class SendData implements ChattingData {
    private String message;
    private Drawable photo;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

    public Drawable getPhoto() {

        return photo;
    }

    public String getMessage() {
        return message;
    }
}
