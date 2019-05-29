package com.example.doaamubdr.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void about(View view) {
        Intent b1 =new Intent(MainActivity.this,aboutActivity.class);
        startActivity(b1);
    }

    public void userLogin(View view) {

        Intent b1 =new Intent(MainActivity.this,LoginActivity.class);
        startActivity(b1);

    }

}
