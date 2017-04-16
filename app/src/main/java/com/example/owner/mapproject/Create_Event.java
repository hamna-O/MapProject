package com.example.owner.mapproject;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.owner.mapproject.Models.Event_model;
import com.example.owner.mapproject.Models.User;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.author;
import static android.app.Activity.RESULT_OK;

import static com.example.owner.mapproject.R.id.map;



public class Create_Event extends Fragment{
    View myView;
    Button b1,d1,t1;
    EditText title, date, time, des;
    TextView venue;
    private com.example.owner.mapproject.retrofit.Map map;
    private CompositeDisposable mCompositeDisposable;
    private int PLACE_PICKER_REQUEST=999;
    SharedPreferences sharedpreferences;
  //  private DatabaseReference database;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  database =FirebaseDatabase.getInstance().getReference();
        setHasOptionsMenu(true);
      //  SharedPreferences sx = getSharedPreferences("S_PIN_STORE", Context.MODE_PRIVATE);
       // database.child(userid);
        mCompositeDisposable = new CompositeDisposable();

        map = new Retrofit
                .Builder()
                .baseUrl("http://map.ssabeer.com/v1/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(com.example.owner.mapproject.retrofit.Map.class);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.create_event,container,false);
        b1= (Button) myView.findViewById(R.id.button);
        title= (EditText) myView.findViewById(R.id.e_title);
       // date= (EditText) myView.findViewById(R.id.e_date);
       // time= (EditText) myView.findViewById(R.id.e_time);
        venue= (TextView) myView.findViewById(R.id.e_venue);
        des= (EditText) myView.findViewById(R.id.e_des);
        d1=(Button)myView.findViewById(R.id.d1);
        t1=(Button)myView.findViewById(R.id.t1);


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
     
      d1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            //  public void showDatePickerDialog(View v) {
                  DialogFragment newFragment = new DatePickerFragment();
                  newFragment.show(getFragmentManager(),"datePicker");
             // }
          }
      });
        t1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      DialogFragment newFragment = new TimePickerFragment();
                                      // TimePickerFragment newFragment = new    TimePickerFragment();
                                      newFragment.show(getFragmentManager(), "timePicker");
                                  }
                              });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Title=title.getText().toString().trim();
              String Date=date.getText().toString().trim();
              String Time=time.getText().toString().trim();
                String Des=des.getText().toString().trim();
                SharedPreferences sp = getActivity().getSharedPreferences("S_PIN_STORE", Context.MODE_PRIVATE);
                String id = sp.getString("ID", "");
                // getString(user, userss._id)
                mCompositeDisposable.add(
                        map.addEvent(new Event_model("jshd67-sjdsj7-sdj78-jdj78", Title, Date, Time, Des, place_name, latitude,  longitude))
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe(new Consumer<Boolean>() {
                                    @Override
                                    public void accept(Boolean user) throws Exception {
                                        userss = user;
                                        Log.d("Success", "Successfully completed.");


                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {
                                        Log.d("Error", throwable.getMessage());
                                    }
                                })
                );

            }
        });
        return myView;
    }
   private Boolean userss;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //checkPermissionOnActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
                    Place place = PlacePicker.getPlace(this.getActivity(), data);
                    String placeName = String.format("%s", place.getName());
                    venue.setText(placeName);

                    place_name=place.getName();
                    latitude = place.getLatLng().latitude;
                    longitude = place.getLatLng().longitude;

        }

    }
    private CharSequence place_name;
    private double latitude;
    private double longitude;

    /*public void onCreateOptionsMenu(
            Menu menu,MenuInflator inflator){
        inflator.inflate(R.menu.activity_nav_main_drawer, menu);

    }*/


}