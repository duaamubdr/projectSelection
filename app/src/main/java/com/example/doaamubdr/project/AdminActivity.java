package com.example.doaamubdr.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button supervisor_btn = findViewById(R.id.supervisor);
        supervisor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b1 =new Intent(AdminActivity.this,supervisorActivity.class);
                startActivity(b1);
            }
        });

        Button add_student_btn = findViewById(R.id.add_student);
        add_student_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b1 =new Intent(AdminActivity.this,RegisterationActivity.class);
                startActivity(b1);
            }
        });

        Button result_btn = findViewById(R.id.admin);
        result_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b1 =new Intent(AdminActivity.this,resultActivity.class);
                startActivity(b1);
            }
        });
    }
}
