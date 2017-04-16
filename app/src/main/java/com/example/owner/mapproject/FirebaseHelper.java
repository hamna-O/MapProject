package com.example.owner.mapproject;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by owner on 4/15/2017.
 */
public class FirebaseHelper {


    /**
     * Created by owner on 4/14/2017.
     */


        DatabaseReference database;
        Boolean saved = null;
        ArrayList<Event> EventDetails = new ArrayList<>();

        public FirebaseHelper(DatabaseReference database) {
            this.database = this.database;
        }

        public Boolean save(Event EventDetails) {
            if (EventDetails == null) {
                saved = false;
            } else {
                try {
                    database.child("Event Details").push().setValue(EventDetails);
                    saved = true;
                } catch (DatabaseException e) {
                    e.printStackTrace();
                    saved = false;
                }
            }
            return saved;
        }

        public ArrayList<Event> retrieve() {
            database.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Event edetails = dataSnapshot.getValue(Event.class);
                    EventDetails.add(edetails);

                }


                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    //  Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                }
            });
            return EventDetails;

        }



    }


