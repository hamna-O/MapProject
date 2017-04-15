package com.example.owner.mapproject.retrofit;

import com.example.owner.mapproject.Models.User;

import org.w3c.dom.UserDataHandler;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by owner on 4/15/2017.
 */

public interface Map {
    @POST("/user")
    Observable<User> userReg(
            @Body User detail
            );

}
