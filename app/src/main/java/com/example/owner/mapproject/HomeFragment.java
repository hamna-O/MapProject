package com.example.owner.mapproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;


public class HomeFragment extends Fragment {
    View myView;
    private GoogleMap mMap;
    private Marker m;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.fragment_home,container,false);

/*
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager(). fin
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
*/


        return myView;
    }
}
