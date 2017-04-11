package com.example.owner.mapproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Khadeeja on 02-03-2017.
 */

public class My_Events extends Fragment{
    View myView;
   
    ListView event_list;

    /*@Override
  public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    }*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.my_events,container,false);

        event_list= (ListView) myView.findViewById(R.id.listview_my_events);

        return myView;
    }

}
