package com.example.doaamubdr.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class briefActivity extends AppCompatActivity {

    TextView project_id;
    TextView supervisor_name;
    TextView project_name;
    TextView brief;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brief);


        project_id = findViewById(R.id.project_id);
        supervisor_name = findViewById(R.id.supervisorN);
        project_name = findViewById(R.id.projectN);
        brief = findViewById(R.id.brief);

        String id = getIntent().getExtras().getString("project_id");
        String supervisorN = getIntent().getExtras().getString("supervisor_name");
        String projectN = getIntent().getExtras().getString("project_name");
        String brieff = getIntent().getExtras().getString("brief");

        project_id.setText(id);
        supervisor_name.setText(supervisorN);
        project_name.setText(projectN);
        brief.setText(brieff);

    }
}
