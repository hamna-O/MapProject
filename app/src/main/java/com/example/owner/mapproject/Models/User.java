package com.example.owner.mapproject.Models;

/**
 * Created by owner on 4/15/2017.
 */

public class User {
    public String _id;
    public  String email;
    public  String name;

    public User(String name, String email) {
        this.email = email;
        this.name = name;
        this._id = "";
    }
}
