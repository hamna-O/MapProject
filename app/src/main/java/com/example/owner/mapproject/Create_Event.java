package com.example.owner.mapproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Khadeeja on 02-03-2017.
 */

public class Create_Event extends Fragment{
    View myView;
    Button b1;
    EditText title, venue, date, time, des;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.create_event,container,false);
        b1= (Button) myView.findViewById(R.id.button);
        title= (EditText) myView.findViewById(R.id.e_title);
        date= (EditText) myView.findViewById(R.id.e_date);
        time= (EditText) myView.findViewById(R.id.e_time);
        venue= (EditText) myView.findViewById(R.id.e_venue);
        des= (EditText) myView.findViewById(R.id.e_des);
      //  cat= (EditText) myView.findViewById(R.id.e);
     /*   FirebaseDatabase database =FirebaseDatabase.getInstance();
        DatabaseReference ref =database.getReference("message");
        ref.setValue("data");*/

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             //  Toast.makeText(getContext(),"hhgbs",Toast.LENGTH_LONG).show();
             //  Firebase Myref =new Firebase("https://mymapsapp-152515.firebaseio.com/");
               FirebaseDatabase database =FirebaseDatabase.getInstance();
               DatabaseReference ref =database.getReference("message");
               ref.setValue("data");
           }
       });
        return myView;
    }
}
