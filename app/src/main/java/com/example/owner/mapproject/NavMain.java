package com.example.owner.mapproject;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;


public class NavMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    android.app.FragmentManager fragmentManager;
    FloatingActionButton fab;
    private int PLACE_PICKER_REQUEST=999;
    public Place place;
    Fragment mapFragment;
    int selected;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mapFragment = new MapsHomeFragment();
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.content_frame,mapFragment).commit();
                fab.hide();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame,mapFragment).commit();
        fab.hide();

        navigationView.setNavigationItemSelectedListener(this);
    }







    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_main, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        selected = id;

        //noinspection SimplifiableIfStatement
       if (id == R.id.search_bar) {
           PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
           try {
               startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST); // for activty
               //startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST); // for fragment
           } catch (GooglePlayServicesRepairableException e) {
               e.printStackTrace();
           } catch (GooglePlayServicesNotAvailableException e) {
               e.printStackTrace();
           }


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //checkPermissionOnActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            place = PlacePicker.getPlace(this, data);
            if(mapFragment!=null) {
                ((MapsHomeFragment)mapFragment).passLocation(place.getLatLng());
                MenuItem item = menu.findItem(selected);
                item.setTitle(place.getName());
            }
        }

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //android.app.FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_create_event || id == -1) {
            fragmentManager.beginTransaction().replace(R.id.content_frame,new Create_Event()).commit();
            //this.getActionBar().setTitle("Create Event");
            fab.show();
        } else if (id == R.id.nav_my_events) {
            fragmentManager.beginTransaction().replace(R.id.content_frame,new My_Events()).commit();
            fab.show();
        } else if (id == R.id.nav_favs) {
            fragmentManager.beginTransaction().replace(R.id.content_frame,new Favs()).commit();
            fab.show();
        }  else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
