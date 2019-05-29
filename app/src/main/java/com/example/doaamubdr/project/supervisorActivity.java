package com.example.doaamubdr.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doaamubdr.project.data.Project;
import com.example.doaamubdr.project.data.User;
import com.example.doaamubdr.project.network.ApiClient;
import com.example.doaamubdr.project.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class supervisorActivity extends AppCompatActivity {

     EditText supervisorName;
    EditText projectName;
    EditText brief;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor);

    }
          void supervisor (final String supervisorName, String projectName,String brief){

              ApiInterface api = ApiClient.initializeRequest().create(ApiInterface.class);
              api.supervisor(supervisorName,projectName,brief).enqueue(new Callback<Project>(){
                  @Override
                  public void onResponse(Call<Project> call, Response<Project> response) {
                      if(response.body().getResponse().equals("ok")){
                          Toast.makeText(supervisorActivity.this,"project added successfully", Toast.LENGTH_LONG).show();
                      }
                      else if(response.body().getResponse().equals("exist"))
                      {
                          Toast.makeText(supervisorActivity.this,"project already exist...", Toast.LENGTH_SHORT).show();
                      }
                      else if(response.body().getResponse().equals("error"))
                      {
                          Toast.makeText(supervisorActivity.this,"Something went wrong...", Toast.LENGTH_SHORT).show();
                      }
                  }

                  @Override
                  public void onFailure(Call<Project> call, Throwable t) {

                  }
              });

          }



      public void send(View view){

         supervisorName = findViewById(R.id.supervisorName);
         projectName = findViewById(R.id.projectName);
          brief = findViewById(R.id.brief);

          String  supervisor = supervisorName.getText().toString();
          String project = projectName.getText().toString();
          String brieff = projectName.getText().toString();
          supervisor(supervisor , project , brieff);
        supervisorName.setText("");
        projectName.setText("");
        brief.setText("");


      }
}
