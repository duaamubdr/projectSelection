package com.example.doaamubdr.project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doaamubdr.project.data.User;
import com.example.doaamubdr.project.network.ApiClient;
import com.example.doaamubdr.project.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    EditText userNameEditText;
    EditText passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    void registerUser(String username,String password){
        ApiInterface api = ApiClient.initializeRequest().create(ApiInterface.class);

        api.peformUserLogin(username,password).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(response.body().getResponse().equals("failed"))
                {
                    Toast.makeText(LoginActivity.this, "sorry!.. you don't have permission", Toast.LENGTH_LONG).show();

                }


                else if(response.body().getResponse().equals("ok"))
                {
                    if (response.body().getUserType().equals("admin")) {
                        Toast.makeText(LoginActivity.this, "Welcome Admin...", Toast.LENGTH_LONG).show();
                        Intent b1 = new Intent(LoginActivity.this, AdminActivity.class);
                        startActivity(b1);
                    }


                    else if  (response.body().getUserType().equals("supervisor")) {
                    Toast.makeText(LoginActivity.this, "Welcome supervisor...", Toast.LENGTH_LONG).show();
                    Intent b1 = new Intent(LoginActivity.this, supervisorActivity.class);
                    startActivity(b1);

                      }

                    else {
                        String user_id = response.body().getUser_id();
                        Toast.makeText(LoginActivity.this, "student..." , Toast.LENGTH_LONG).show();
                        Intent b1 = new Intent(LoginActivity.this, studentActivity.class);
                        b1.putExtra("user_id", user_id);
                        startActivity(b1);
                    }
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Login failed..please try again later...", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void login(View view){
        userNameEditText = findViewById(R.id.user_name);
        passwordEditText = findViewById(R.id.user_pass);
        String  username = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        registerUser(username,password);


}}
