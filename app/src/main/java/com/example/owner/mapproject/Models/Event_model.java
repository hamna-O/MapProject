package com.example.owner.mapproject.Models;

/**
 * Created by owner on 4/16/2017.
 */

public class Event_model {
    public String _id;
    public String title;
    public String time;
    public String date;
    public String des;
    public String user;
   // public String venue;
    public CharSequence place_name;
    public double latitude;
    public double longitude;


    public Event_model(String user, String title, String date, String time, String des, CharSequence place_name, double latitude, double longitude ){

        /*constructor*/
        this._id = "";
        this.user=user;
        this.title = title;
        this.des = des;
        this.date=date;
        this.time=time;
        this.place_name=place_name;
       // this.venue=venue;
        this.latitude=latitude;
        this.longitude=longitude;

    }

}
