package com.example.owner.mapproject;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Khadeeja on 02-03-2017.
 */

public class Create_Event extends Fragment{
    View myView;
    Button b1;
    EditText title, date, time, des;
    TextView venue;
    private int PLACE_PICKER_REQUEST=999;
    private DatabaseReference database;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database =FirebaseDatabase.getInstance().getReference();

       // database.child(userid);


    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.create_event,container,false);
        b1= (Button) myView.findViewById(R.id.button);
        title= (EditText) myView.findViewById(R.id.e_title);
        date= (EditText) myView.findViewById(R.id.e_date);
        time= (EditText) myView.findViewById(R.id.e_time);
        venue= (TextView) myView.findViewById(R.id.e_venue);
        des= (EditText) myView.findViewById(R.id.e_des);




        venue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST); // for activty
                    //startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST); // for fragment
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String Title=title.getText().toString().trim();
               String Date=date.getText().toString().trim();
               String Time=time.getText().toString().trim();
               String Des=des.getText().toString().trim();
               database.child("Event Title").setValue(Title);
               database.child("Description").setValue(Des);

             //  ref.child("date").setValue(date.toString());
             //  ref.child("time").setValue()
//               ref.child("venue").setValue(venue);


           }
       });
        return myView;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //checkPermissionOnActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
                    Place place = PlacePicker.getPlace(this.getActivity(), data);
                    String placeName = String.format("%s", place.getName());
            venue.setText(placeName);


                    //String latitude = place.getLatLng().latitude;
                    //var longitude = place.getLatLng().longitude;
        }

    }
}

