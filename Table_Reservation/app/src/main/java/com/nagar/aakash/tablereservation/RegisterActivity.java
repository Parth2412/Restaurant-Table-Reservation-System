package com.nagar.aakash.tablereservation;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nagar.aakash.tablereservation.api.ApiConfig;
import com.nagar.aakash.tablereservation.api.ApiInterface;
import com.nagar.aakash.tablereservation.result.UserResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";
    EditText pass, name, email, mobile;
    Button btnRegister;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        pass = findViewById(R.id.regPass);
        name = findViewById(R.id.regName);
        email = findViewById(R.id.regEmail);
        mobile = findViewById(R.id.regMobile);
        btnRegister = findViewById(R.id.regBtnRegister);

        progressDialog = new ProgressDialog(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

    }

    public void loginActivity(View view) {
        Intent toLogin=new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(toLogin);
        finish();
    }

    private void registerUser() {

        String strname = name.getText().toString();
        String strpass = pass.getText().toString();
        String stremail = email.getText().toString();
        Integer strmobile = Integer.parseInt(mobile.getText().toString());

        Call<UserResult> call = ApiConfig.getClient().create(ApiInterface.class).signUpUser(strname, stremail, strpass, strmobile);

        call.enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                if(response.code()==200){
                    Log.i(TAG, "onResponse: " + true + response.body().isStatus()) ;
                    if(response.body().isStatus())
                    {
                        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }else{
                    Log.i(TAG, "onResponse: " + false + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {

            }
        });
    }
}