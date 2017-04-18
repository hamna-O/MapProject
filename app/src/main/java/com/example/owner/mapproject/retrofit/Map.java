package com.example.owner.mapproject.retrofit;

import com.example.owner.mapproject.Event;
import com.example.owner.mapproject.Models.Event_model;
import com.example.owner.mapproject.Models.User;

import org.w3c.dom.UserDataHandler;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by owner on 4/15/2017.
 */

public interface Map {
    @POST("user/")
    Observable<User> userReg(
            @Body User detail
            );
    @POST("events/")
    Observable<Boolean> addEvent(
            @Body Event_model event
    );

    @GET("events/local")
    Observable<List<Event>> getLocalEvents(
            @Query("latitude") String latitude,
            @Query("longitude") String longitude
    );

}
