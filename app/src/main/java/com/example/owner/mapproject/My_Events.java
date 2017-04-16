package com.example.owner.mapproject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.usage.UsageEvents;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khadeeja on 02-03-2017.
 */

public class My_Events extends Fragment{
    View myView;
    ListView event_list;
    ArrayAdapter<String> adapter;
    DatabaseReference database;
    FirebaseHelper helper;



    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        //database=FirebaseDatabase.getInstance().getReference();
        //helper= new FirebaseHelper(database);


        //   adapter=new ArrayAdapter<String>(this,android.R.layout.activity_list_item,helper.retrieve());
        // event_list.setAdapter(adapter);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.my_events,container,false);
        event_list= (ListView) myView.findViewById(R.id.listview_my_events);

        List<String> item = new ArrayList<>();
        item.add("Festival");item.add("Wedding");item.add("Live Concert");item.add("Football Tournament");
        EventAdapter adapter = new EventAdapter(this.getActivity(), item);

        event_list.setAdapter(adapter);

        event_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Fragment newFragment = new EventDetails();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack
                transaction.replace(R.id.content_frame, newFragment);
                transaction.addToBackStack(null);

// Commit the transaction
                transaction.commit();

            }
        });

        // helper = new FirebaseHelper(database);
        return myView;
    }

}
