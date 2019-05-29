package com.example.doaamubdr.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.example.doaamubdr.project.data.Project;
import com.example.doaamubdr.project.network.ApiClient;
import com.example.doaamubdr.project.network.ApiInterface;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class projects extends AppCompatActivity {

   private RecyclerView recyclerView;
    private projectsAdapter adapter;
    private List<Project> projectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager( new LinearLayoutManager(this));


        ApiInterface api = ApiClient.initializeRequest().create(ApiInterface.class);
        api.getProjets().enqueue(new Callback<Project>() {

            @Override
            public void onResponse(Call<Project> call, Response<Project> response) {

              projectList = response.body().getProjects();
              adapter = new projectsAdapter(projects.this,projectList);
              recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<Project> call, Throwable t) {
                Toast.makeText(projects.this,"Something went wrong...", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
