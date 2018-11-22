package com.nagar.aakash.tablereservation;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.nagar.aakash.tablereservation.Utilities.MyConstants;
import com.nagar.aakash.tablereservation.api.ApiConfig;
import com.nagar.aakash.tablereservation.api.ApiInterface;
import com.nagar.aakash.tablereservation.pojos.UserPOJO;
import com.nagar.aakash.tablereservation.result.UserResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG="LoginActivity";
    EditText unm,pass;
    Button btnLogin,btnRegister;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unm=findViewById(R.id.lgnunm);
        pass=findViewById(R.id.lgnpass);

        btnLogin=findViewById(R.id.lgnbtnlogin);
        btnRegister=findViewById(R.id.lgnbtnregister);

        progressDialog = new ProgressDialog(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loginUser();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });

    }
    private void loginUser(){
        final String user_name = unm.getText().toString();
        String user_password = pass.getText().toString();

        Call<UserResult> call=ApiConfig.getClient().create(ApiInterface.class).loginUser(user_name,user_password);

        Log.i(TAG, "loginUser: " + user_name + user_password);
        call.enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                if(response.code()==200){
                    Log.i(TAG, "onResponse: " + true + response.body().isStatus() + response.body().getMsg()) ;
                    if(response.body().isStatus())
                    {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        UserPOJO user = response.body().getUserPOJO();
                        Log.i(TAG, "onResponse: " + response.body().getUserPOJO().getUser_id());
                        UserPOJO storeuser = MyConstants.getUserPOJO();
                        storeuser.setUser_id(user.getUser_id());
                        storeuser.setUser_name(user.getUser_name());
                        storeuser.setUser_contact_no(user.getUser_contact_no());
                        storeuser.setUser_email(user.getUser_email());
                        storeuser.setUser_password(user.getUser_password());
                        startActivity(intent);
                        finish();
                    }
                }else{
                    Log.i(TAG, "onResponse: " + false + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                Log.i(TAG, "onFailure: " ,t);
            }
        });
    }



}
