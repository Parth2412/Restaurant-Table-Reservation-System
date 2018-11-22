package com.nagar.aakash.tablereservation.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nagar.aakash.tablereservation.R;
import com.nagar.aakash.tablereservation.RestaurantDetail;
import com.nagar.aakash.tablereservation.pojos.RestaurantPOJO;

import java.util.List;

/**
 * Created by Aakash on 06-Nov-18.
 */

public class RestaurantListAdaptor extends BaseAdapter {
    private Context mContext;
    private List<RestaurantPOJO> mRestaurantPOJOList;

    public RestaurantListAdaptor(Context mContext, List<RestaurantPOJO> mRestaurantPOJOList, String selectedCity) {
        this.mContext = mContext;
        this.mRestaurantPOJOList = mRestaurantPOJOList;
    }

    @Override
    public int getCount() {
        return mRestaurantPOJOList.size();
    }

    @Override
    public Object getItem(int position) {
        return mRestaurantPOJOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final View v=View.inflate(mContext,R.layout.activity_custom_list_item,null);
        TextView tvName=v.findViewById(R.id.tvListItemName);
        TextView tvAddress=v.findViewById(R.id.tvListItemAddress);

        ImageView imageView=v.findViewById(R.id.ivListItemImage);


        tvName.setText(mRestaurantPOJOList.get(position).getRestaurant_name());
        tvAddress.setText(mRestaurantPOJOList.get(position).getRestaurant_address());

        //imageView.setImageResource(R.drawable.food);// Set Image path

        String url = mRestaurantPOJOList.get(position).getRestaurant_image();
        Glide.with(v).load(url).into(imageView);
        v.setTag(mRestaurantPOJOList.get(position).getRestaurant_id());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,RestaurantDetail.class);
                intent.putExtra("restaurant",mRestaurantPOJOList.get(position));
                mContext.startActivity(intent);
            }
        });
//        MainActivity mainActivity;
        return v;
    }

    public void addData(List<RestaurantPOJO> mRestaurantPOJOS) {
        this.mRestaurantPOJOList = mRestaurantPOJOS;
        notifyDataSetChanged();
    }
}
