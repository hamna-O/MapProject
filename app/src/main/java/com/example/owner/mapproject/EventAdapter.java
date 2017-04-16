package com.example.owner.mapproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class EventAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    public List<String> items;

    public EventAdapter(Context context, List<String> items){
        this.items = items;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public String getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String item = items.get(position);

        convertView = mInflater.inflate(R.layout.listviewitem, null);

        ((TextView) convertView.findViewById(R.id.TitleText)).setText(item);

        return convertView;
    }
}

