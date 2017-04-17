package com.example.owner.mapproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khadeeja on 02-03-2017.
 */

public class Favs extends Fragment{
    View myView;
    ListView event_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.favs,container,false);

        event_list= (ListView) myView.findViewById(R.id.listview_my_events);

        List<String> item = new ArrayList<>();
        item.add("Festival");item.add("Wedding");item.add("Live Concert");item.add("Football Tournament");
        EventAdapter adapter = new EventAdapter(this.getActivity(), item);

        event_list.setAdapter(adapter);

        return myView;
    }
}
