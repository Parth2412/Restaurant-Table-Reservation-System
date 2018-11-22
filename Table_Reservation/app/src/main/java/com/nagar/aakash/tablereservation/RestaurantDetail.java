package com.nagar.aakash.tablereservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nagar.aakash.tablereservation.pojos.RestaurantPOJO;

public class RestaurantDetail extends AppCompatActivity {
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
        setContentView(R.layout.activity_restaurant_detail);

        TextView tvName=findViewById(R.id.tvResDetName);
        TextView tvAddress=findViewById(R.id.tvResDetAddress);
        ImageView img = findViewById(R.id.imageView);
        TextView tvTable2=findViewById(R.id.tvTable2);
        TextView tvTable4=findViewById(R.id.tvTable4);
        TextView tvTable6=findViewById(R.id.tvTable6);
        TextView tvTable8=findViewById(R.id.tvTable8);
        TextView tvTableTotal=findViewById(R.id.tvTableTotal);

        final RestaurantPOJO restaurant = (RestaurantPOJO) getIntent().getSerializableExtra("restaurant");

//        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        tvName.setText(restaurant.getRestaurant_name());
        tvAddress.setText(restaurant.getRestaurant_address());
        Glide.with(this).load(restaurant.getRestaurant_image()).into(img);
        tvTable2.setText(restaurant.getRestaurant_2s_table().toString());
        tvTable4.setText(restaurant.getRestaurant_4s_table().toString());
        tvTable6.setText(restaurant.getRestaurant_6s_table().toString());
        tvTable8.setText(restaurant.getRestaurant_8s_table().toString());
        tvTableTotal.setText(restaurant.getRestaurant_total_table().toString());
        Button btnBook=findViewById(R.id.btnBookNow);

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTableBooking=new Intent(getApplicationContext(),TableBooking.class);
                intentTableBooking.putExtra("restaurant",restaurant);
                //startActivityForResult(intentTableBooking,1);
                startActivity(intentTableBooking);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            finish();
        }
    }
}

