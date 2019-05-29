package com.example.doaamubdr.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class studentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Button displayProjectsBtn = findViewById(R.id.display_projects);
        displayProjectsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent b1 =new Intent(studentActivity.this,projects.class);
                startActivity(b1);
            }
        });
        Button chooseProject = findViewById(R.id.choose_project);
        chooseProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b2 =new Intent(studentActivity.this,selectionActivity.class);
                String user_id = getIntent().getExtras().getString("user_id");
                b2.putExtra("user_id", user_id);
                startActivity(b2);
            }
        });





    }
}
