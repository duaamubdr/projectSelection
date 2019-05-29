package com.example.doaamubdr.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.doaamubdr.project.data.Result;
import com.example.doaamubdr.project.network.ApiClient;
import com.example.doaamubdr.project.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class resultActivity extends AppCompatActivity {


        private RecyclerView recyclerView;
        private resultsAdapter adapter;
        private List<Result> resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager( new LinearLayoutManager(this));


        ApiInterface api = ApiClient.initializeRequest().create(ApiInterface.class);
        api.getResults().enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                resultList = response.body().getResult();
                adapter = new resultsAdapter(resultActivity.this,resultList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(resultActivity.this,"Something went wrong...", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
