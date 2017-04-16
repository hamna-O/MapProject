package com.example.owner.mapproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {


    public TimePickerFragment() {
        // Required empty public constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker

        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
      /*  return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity())); */
        TimePickerDialog tpd = new TimePickerDialog(getActivity(),
                AlertDialog.THEME_HOLO_LIGHT,this,hour,minute,false);
        return tpd;
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        String format;
        if (hourOfDay == 0) {

            hourOfDay += 12;

            format = "AM";
        } else if (hourOfDay == 12) {

            format = "PM";

        } else if (hourOfDay > 12) {

            hourOfDay -= 12;

            format = "PM";

        } else {

            format = "AM";
        }

       /* StringBuilder sb = new StringBuilder();
        String time;
        sb.append(hourOfDay);
        sb.append('-');
        sb.append(minute);

        time = sb.toString();
        System.out.println("The time is "+ time);
        ((Button) getActivity().findViewById(R.id.t1)).setText(time);*/
        ((Button) getActivity().findViewById(R.id.t1)).setText(hourOfDay + ":" + minute + format);
        // t1.setText(hourOfDay + ":" + minute + format);
    }
}