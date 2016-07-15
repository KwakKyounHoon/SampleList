package com.example.tacademy.samplelist;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.tacademy.samplelist.data.ChildItem;
import com.example.tacademy.samplelist.data.GroupItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-07-15.
 */
public class MyGroupAdapter extends BaseExpandableListAdapter {
    List<GroupItem> items = new ArrayList<>();

    public void put(String groupName, String childName) {
        GroupItem group= null;
        for(GroupItem g : items){
            if(g.groupName.equals(groupName)){
                group = g;
                break;
            }
        }
        if(group == null){
            group = new GroupItem();
            group.groupName = groupName;
            items.add(group);
        }

        if (!TextUtils.isEmpty(childName)) {
            ChildItem child = new ChildItem();
            child.name = childName;
            group.children.add(child);
        }
    }

    @Override
    public int getGroupCount() {
        return items.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return items.get(i).children.size();
    }

    @Override
    public Object getGroup(int position) {
        return items.get(position);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return items.get(groupPosition).children.get(childPosition);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView textView;
        if(convertView == null){
            textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            textView.setBackgroundColor(Color.GREEN);
        }else{
            textView = (TextView)convertView;
        }

        textView.setText(items.get(groupPosition).groupName);
        return textView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView view;
        if (convertView == null) {
            view = (TextView)LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            view.setBackgroundColor(Color.YELLOW);
        } else {
            view = (TextView)convertView;
        }

        if (isLastChild) {
            view.setBackgroundColor(Color.LTGRAY);
        } else {
            view.setBackgroundColor(Color.YELLOW);
        }
        view.setText(items.get(groupPosition).children.get(childPosition).name);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
