package com.example.owner.mapproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventDetail extends AppCompatActivity {
    TextView title,time,date,desc;
    private com.example.owner.mapproject.retrofit.Map map;
    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        title = (TextView) findViewById(R.id.eventtitle);
        date = (TextView) findViewById(R.id.eventdate);
        desc = (TextView) findViewById(R.id.eventdesc);
        time = (TextView) findViewById(R.id.eventtime);

        mCompositeDisposable = new CompositeDisposable();
        map = new Retrofit
                .Builder()
                .baseUrl("http://map.ssabeer.com/v1/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(com.example.owner.mapproject.retrofit.Map.class);


    }
}
