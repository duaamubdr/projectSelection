package com.example.doaamubdr.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doaamubdr.project.data.selection;
import com.example.doaamubdr.project.network.ApiClient;
import com.example.doaamubdr.project.network.ApiInterface;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class selectionActivity extends AppCompatActivity {


    EditText edId1,edId2,edId3,edId4,edId5;
    EditText edOrder1,edOrder2,edOrder3,edOrder4,edOrder5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);




    }


    void selection(String user_id,int id1,int order1) {
        ApiInterface api = ApiClient.initializeRequest().create(ApiInterface.class);

        api.performSelection(user_id,id1, order1)
                .enqueue(new Callback<selection>() {
                    @Override
                    public void onResponse(Call<selection> call, Response<selection> response) {

                        if(response.body().getResponse().equals("ok"))
                        {


                            Button send = findViewById(R.id.send);
                            TextView after_send = findViewById(R.id.after_send);
                            send.setVisibility(View.INVISIBLE);
                            after_send.setText("thank you..");
                        }
                    }

                    @Override
                    public void onFailure(Call<selection> call, Throwable t) {
                        Toast.makeText(selectionActivity.this,"something went wrong...", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    public void send(View view) {

        String user_id = getIntent().getExtras().getString("user_id");
        Toast.makeText(selectionActivity.this,"successfully sent...", Toast.LENGTH_LONG).show();


        edId1=findViewById(R.id.project_id1);
        edId2=findViewById(R.id.project_id2);
        edId3=findViewById(R.id.project_id3);
        edId4=findViewById(R.id.project_id4);
        edId5=findViewById(R.id.project_id5);
        edOrder1=findViewById(R.id.order1);
        edOrder2=findViewById(R.id.order2);
        edOrder3=findViewById(R.id.order3);
        edOrder4=findViewById(R.id.order4);
        edOrder5=findViewById(R.id.order5);

        int  id1 = Integer.parseInt(edId1.getText().toString());
        int  id2 = Integer.parseInt(edId2.getText().toString());
        int  id3 =Integer.parseInt(edId3.getText().toString());
        int  id4 = Integer.parseInt(edId4.getText().toString());
        int  id5 = Integer.parseInt(edId5.getText().toString());
        int order1 = Integer.parseInt(edOrder1.getText().toString());
        int order2 = Integer.parseInt(edOrder2.getText().toString());
        int order3 =Integer.parseInt( edOrder3.getText().toString());
        int order4 = Integer.parseInt(edOrder4.getText().toString());
        int order5 = Integer.parseInt(edOrder5.getText().toString());

        selection(user_id,id1,order1);
        selection(user_id,id2,order2);
        selection(user_id,id3,order3);
        selection(user_id,id4,order4);
        selection(user_id,id5,order5);


    }



    }
