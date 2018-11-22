package com.nagar.aakash.tablereservation.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nagar.aakash.tablereservation.Booking;
import com.nagar.aakash.tablereservation.R;
import com.nagar.aakash.tablereservation.api.ApiConfig;
import com.nagar.aakash.tablereservation.api.ApiInterface;
import com.nagar.aakash.tablereservation.pojos.BookingPOJO;
import com.nagar.aakash.tablereservation.result.DeleteBookingResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

/**
 * Created by Aakash on 15-Nov-18.
 */

public class MyBookingsAdapter extends BaseAdapter {
    private Context mContext;
    private List<BookingPOJO> mBooking;

    public MyBookingsAdapter(Context mContext, List<BookingPOJO> mBooking) {
        this.mContext = mContext;
        this.mBooking = mBooking;
    }

    @Override
    public int getCount() {
        return mBooking.size();
    }

    @Override
    public Object getItem(int position) {
        return mBooking.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v=View.inflate(mContext,R.layout.activity_my_booking_list_item,null);
        TextView tvName=v.findViewById(R.id.mbName);
        TextView tvDate=v.findViewById(R.id.mbDate);
        TextView tvTime=v.findViewById(R.id.mbTime);
        TextView tvPerson=v.findViewById(R.id.mbTotalPerson);
        ImageView imageView=v.findViewById(R.id.mbImageView);
        Button btn=v.findViewById(R.id.mbBtnCancel);

        final BookingPOJO booking = mBooking.get(position);
        Date date = booking.getBooking_date();
        SimpleDateFormat sdf = new SimpleDateFormat("d-MM-YYYY");

        tvName.setText(booking.getRestaurant_name());
        tvDate.setText("Date: "+ sdf.format(date));
        tvTime.setText("Time: "+booking.getBooking_time());
        tvPerson.setText("Total Person: "+booking.getNo_of_person());

        Glide.with(mContext).load(booking.getRestaurant_image()).into(imageView);

        v.setTag(booking.getBooking_id());

        if(date.compareTo(new Date())-1<0){
            btn.setVisibility(View.GONE);
        }else{
            btn.setVisibility(View.VISIBLE);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteBooking(booking.getBooking_id(),position);
            }
        });

        return v;
    }

    private void deleteBooking(Integer booking_id, final int position) {

        Log.i(TAG, "deleteBooking: " + booking_id + " "+position);
        Call<DeleteBookingResult> call = ApiConfig.getClient().create(ApiInterface.class).deleteBooking(booking_id);

        call.enqueue(new Callback<DeleteBookingResult>() {
            @Override
            public void onResponse(Call<DeleteBookingResult> call, Response<DeleteBookingResult> response) {
                if(response.code()==200 && response.body().isStatus()){
                    mBooking.remove(position);
                    notifyDataSetChanged();
                    Toast.makeText(mContext, "Booking cancelled", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(mContext, "Error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<DeleteBookingResult> call, Throwable t) {
                Log.i(TAG, "onFailure: ",t);
            }
        });
    }

    public void changeData(List<BookingPOJO> mBookings) {
        mBooking = mBookings;
        notifyDataSetChanged();
    }
}
