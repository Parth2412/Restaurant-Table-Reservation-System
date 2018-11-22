package com.nagar.aakash.tablereservation;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by Aakash on 06-Nov-18.
 */

public class DatePickerFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePicker=new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener) getActivity(),year,month,day );
        datePicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        return datePicker;
    }
}
