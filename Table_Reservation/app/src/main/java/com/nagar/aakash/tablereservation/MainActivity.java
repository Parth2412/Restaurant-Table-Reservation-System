package com.nagar.aakash.tablereservation;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.nagar.aakash.tablereservation.adapter.RestaurantListAdaptor;
import com.nagar.aakash.tablereservation.api.ApiConfig;
import com.nagar.aakash.tablereservation.api.ApiInterface;
import com.nagar.aakash.tablereservation.pojos.RestaurantPOJO;
import com.nagar.aakash.tablereservation.result.RestaurantResult;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ListView lvRestaurant;
    private RestaurantListAdaptor adaptor;
    private List<RestaurantPOJO> mRestaurantPOJOS;
    TextView tvCity;
    String name;
    String selectedCity;
    Button changeCity;

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

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvRestaurant=findViewById(R.id.list1);
        progressDialog = new ProgressDialog(this);

        mRestaurantPOJOS = new LinkedList<>();

        getRestaurant(0);
        
        adaptor=new RestaurantListAdaptor(getApplicationContext(), mRestaurantPOJOS,selectedCity);
        lvRestaurant.setAdapter(adaptor);


        tvCity=findViewById(R.id.homeCity);
       // tvCity.setText(getIntent().getStringExtra("name"));
        changeCity=findViewById(R.id.homeBtnChangeCity);
        changeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                View mview=getLayoutInflater().inflate(R.layout.layout_spinner,null);
                builder.setTitle("Select City");

                final Spinner spinner=mview.findViewById(R.id.spinner);

                ArrayAdapter<String> mAdapter=new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.spinner_city));
                mAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                spinner.setAdapter(mAdapter);

                builder.setPositiveButton("Select", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!spinner.getSelectedItem().toString().equalsIgnoreCase("Choose City...")){
                            selectedCity=spinner.getSelectedItem().toString();
                            tvCity.setText("Current City : "+selectedCity);
                            //Loading RestaurantPOJO Details into list
                            getRestaurant(spinner.getSelectedItemPosition());
                            Toast.makeText(MainActivity.this, "" + spinner.getSelectedItemPosition(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setView(mview);
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });

    }

    private void getRestaurant(int i) {
        Call<RestaurantResult> call = ApiConfig.getClient().create(ApiInterface.class).getAllRestaurant(i);
        call.enqueue(new Callback<RestaurantResult>() {
            @Override
            public void onResponse(Call<RestaurantResult> call, Response<RestaurantResult> response) {
                if(response.code()==200 && response.body().isStatus()){
                    mRestaurantPOJOS=response.body().getRestaurants();
                    Log.i(TAG, "onResponse: " + mRestaurantPOJOS.size());
                    adaptor.addData(mRestaurantPOJOS);
                }else {
                    Log.i(TAG, "onResponse: " + response.errorBody().toString());
                }
                Log.i(TAG, "onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<RestaurantResult> call, Throwable t) {
                Log.i(TAG, "onFailure: ",t);
            }
        });
    }
}
