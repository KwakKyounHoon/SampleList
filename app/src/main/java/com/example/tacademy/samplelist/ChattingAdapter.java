package com.example.tacademy.samplelist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tacademy.samplelist.data.ChattingData;
import com.example.tacademy.samplelist.data.DateData;
import com.example.tacademy.samplelist.data.ReceiveData;
import com.example.tacademy.samplelist.data.SendData;
import com.example.tacademy.samplelist.widget.DateView;
import com.example.tacademy.samplelist.widget.ReceiveView;
import com.example.tacademy.samplelist.widget.SendView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class ChattingAdapter extends BaseAdapter {
    List<ChattingData> items = new ArrayList<>();

    private static final int VIEW_TYPE_COUNT = 3;
    private static final int VIEW_INDEX_SEND = 0;
    private static final int VIEW_INDEX_RECEIVE = 1;
    private static final int VIEW_INDEX_DATE = 2;

    public void add(ChattingData data){
        items.add(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        ChattingData data = items.get(position);
        if(data instanceof SendData){
            return VIEW_INDEX_SEND;
        }else if(data instanceof ReceiveData){
            return VIEW_INDEX_RECEIVE;
        }else{
            return VIEW_INDEX_DATE;
        }
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        switch (getItemViewType(i)){
            case VIEW_INDEX_SEND : {
                SendView view;
                if (convertView == null || !(convertView instanceof SendView)) {
                    view = new SendView(parent.getContext());
                } else {
                    view = (SendView) convertView;
                }
                view.setData((SendData) items.get(i));
                return view;
            }
            case  VIEW_INDEX_RECEIVE : {
                ReceiveView view;
                if (convertView == null || !(convertView instanceof ReceiveView)) {
                    view = new ReceiveView(parent.getContext());
                } else {
                    view = (ReceiveView) convertView;
                }
                view.setData((ReceiveData) items.get(i));
                return view;
            }
            case VIEW_INDEX_DATE :
            default: {
                DateView view;
                if (convertView == null || !(convertView instanceof DateView)) {
                    view = new DateView(parent.getContext());
                } else {
                    view = (DateView) convertView;
                }
                view.setData((DateData) items.get(i));
                return view;
            }

        }
    }
}
