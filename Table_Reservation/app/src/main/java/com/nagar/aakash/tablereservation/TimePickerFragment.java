package com.nagar.aakash.tablereservation;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by Aakash on 06-Nov-18.
 */

public class TimePickerFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c=Calendar.getInstance();
        int hour =c.get(Calendar.HOUR_OF_DAY);
        int minute =c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),(TimePickerDialog.OnTimeSetListener)getActivity(),hour,minute,false);//android.text.format.DateFormat.is24HourFormat(getActivity())
    }
}
