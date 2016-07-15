package com.example.tacademy.samplelist.widget;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tacademy.samplelist.R;
import com.example.tacademy.samplelist.data.Comment;

/**
 * Created by Tacademy on 2016-07-15.
 */
public class CommentView extends RelativeLayout{
    public CommentView(Context context) {
        super(context);
        initData();
    }

    TextView messageView, writerView;

    private void initData() {
        inflate(getContext(), R.layout.view_comment, this);
        messageView = (TextView)findViewById(R.id.text_message);
        writerView = (TextView)findViewById(R.id.text_writer);
    }

    Comment comment;
    public void setComment(Comment comment){
        this.comment = comment;
        messageView.setText(comment.message);
        writerView.setText(comment.writer);
    }

    public Comment getComment(){return comment;}
}
