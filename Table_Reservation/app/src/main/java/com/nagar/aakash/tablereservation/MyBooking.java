package com.nagar.aakash.tablereservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.nagar.aakash.tablereservation.Utilities.MyConstants;
import com.nagar.aakash.tablereservation.adapter.MyBookingsAdapter;
import com.nagar.aakash.tablereservation.api.ApiConfig;
import com.nagar.aakash.tablereservation.api.ApiInterface;
import com.nagar.aakash.tablereservation.pojos.BookingPOJO;
import com.nagar.aakash.tablereservation.result.ViewBookingResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyBooking extends AppCompatActivity {
    private static final String TAG = "MyBooking";
    private List<BookingPOJO> mBookings;
    private MyBookingsAdapter myBookingsAdapter;
    ListView lvBookings;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking);

        lvBookings=findViewById(R.id.lvMyBooking);
        mBookings=new ArrayList<>();

        getBookings();

        myBookingsAdapter=new MyBookingsAdapter(getApplicationContext(),mBookings);
        lvBookings.setAdapter(myBookingsAdapter);
    }

    private void getBookings() {
        Log.i(TAG, "getBookings: " + MyConstants.getUserPOJO().getUser_id());
        Call<ViewBookingResult> call = ApiConfig.getClient().create(ApiInterface.class).viewBooking(MyConstants.getUserPOJO().getUser_id());

        call.enqueue(new Callback<ViewBookingResult>() {
            @Override
            public void onResponse(Call<ViewBookingResult> call, Response<ViewBookingResult> response) {
                if(response.code()==200 && response.body().isStatus()){
                    mBookings = response.body().getBooking();
                    myBookingsAdapter.changeData(mBookings);
                }else{
                    Log.i(TAG, "onResponse: ");
                }
            }

            @Override
            public void onFailure(Call<ViewBookingResult> call, Throwable t) {
                Log.i(TAG, "onFailure: ",t);
            }
        });
    }
}
