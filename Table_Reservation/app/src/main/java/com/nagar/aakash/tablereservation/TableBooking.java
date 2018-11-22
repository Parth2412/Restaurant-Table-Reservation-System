package com.nagar.aakash.tablereservation;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.nagar.aakash.tablereservation.Utilities.MyConstants;
import com.nagar.aakash.tablereservation.api.ApiConfig;
import com.nagar.aakash.tablereservation.api.ApiInterface;
import com.nagar.aakash.tablereservation.pojos.RestaurantPOJO;
import com.nagar.aakash.tablereservation.pojos.UserPOJO;
import com.nagar.aakash.tablereservation.result.BookingResult;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TableBooking extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{

    private static final String TAG = "TableBooking";
    private EditText name;
    private EditText contact;
    private TextView date;
    private TextView time;
    private TextView tbResName;
    private EditText tbNoOfPerson;
    private RestaurantPOJO restaurant;
    private UserPOJO user;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemMyBookings:
                startActivity(new Intent(this,MyBooking.class));
                return true;
            case R.id.itemLogOut:
                startActivity(new Intent(this,LoginActivity.class));
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_booking);

        restaurant = (RestaurantPOJO) getIntent().getSerializableExtra("restaurant");

        ImageView iv2=findViewById(R.id.tbi2);
        ImageView iv4=findViewById(R.id.tbi4);
        ImageView iv6=findViewById(R.id.tbi6);
        ImageView iv8=findViewById(R.id.tbi8);

        name=findViewById(R.id.tbName);
        contact=findViewById(R.id.tbContact);

        date=findViewById(R.id.tbDate);
        time=findViewById(R.id.tbTime);
        tbResName=findViewById(R.id.tbResName);
        tbResName.setText(restaurant.getRestaurant_name());
        tbNoOfPerson = findViewById(R.id.tvNoOfPerson);
        Button book=findViewById(R.id.tbBtnBook);
        
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment datePicker=new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"Date Picker");
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker=new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"Time Picker");
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doBooking();
                Toast.makeText(TableBooking.this, "Booking done Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        final TextView tvTableSize=findViewById(R.id.tvTableSize);
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTableSize.setText("2");
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTableSize.setText("4");
            }
        });
        iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTableSize.setText("6");
            }
        });
        iv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTableSize.setText("8");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        String selectedDate= DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());
        TextView date=findViewById(R.id.tbDate);
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        date.setText(sdf.format(c.getTime()));

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String am_pm="pm";
        Calendar datetime = Calendar.getInstance();
        datetime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        datetime.set(Calendar.MINUTE, minute);

        TextView time=findViewById(R.id.tbTime);
        time.setText(hourOfDay+":"+minute);
    }

    public void doBooking(){
        String user_name = name.getText().toString();
        String user_contact = contact.getText().toString();
        String user_date = date.getText().toString();
        String user_time = time.getText().toString() + ":00";
        String noOfPerson = tbNoOfPerson.getText().toString();

        Log.i(TAG, "" +
                "doBooking: "+ user_contact + user_name + user_date + user_time + noOfPerson + restaurant.getRestaurant_id()+MyConstants.getUserPOJO().getUser_id());
        Call<BookingResult> call = ApiConfig.getClient().create(ApiInterface.class).bookingUser(user_name,user_date,user_time,user_contact,noOfPerson,restaurant.getRestaurant_id(),MyConstants.getUserPOJO().getUser_id());

        call.enqueue(new Callback<BookingResult>() {
            @Override
            public void onResponse(Call<BookingResult> call, Response<BookingResult> response) {
                Log.i(TAG, "onResponse: " + response.code());
                if(response.body().isStatus()){
                    Log.i(TAG, "onResponse: " + response.body().getMsg());
                    Toast.makeText(TableBooking.this, "Success", Toast.LENGTH_SHORT).show();
                    //finish();
                }else{
                    Toast.makeText(TableBooking.this, "Fail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BookingResult> call, Throwable t) {
                Log.i(TAG, "onFailure: " ,t);
            }
        });
    }
}
