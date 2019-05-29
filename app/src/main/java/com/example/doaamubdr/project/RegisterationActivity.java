package com.example.doaamubdr.project;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.doaamubdr.project.data.User;
import com.example.doaamubdr.project.network.ApiClient;
import com.example.doaamubdr.project.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterationActivity extends AppCompatActivity {


    private static final String TAG = "RegisterationActivity";
    EditText id ;
    EditText txtUsername;
    EditText txtUserType;
    EditText txtPassword;
    EditText average;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

    }
    void registerUser(String id, String username, String password,String userType,String average){

        ApiInterface api = ApiClient.initializeRequest().create(ApiInterface.class);

        api.peformRegisteration(id,username,password,userType,average).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(response.body().getResponse().equals("ok"))
                {
                    Toast.makeText(RegisterationActivity.this,"registeration success", Toast.LENGTH_LONG).show();

                }
                else if(response.body().getResponse().equals("exist"))
                {
                    Toast.makeText(RegisterationActivity.this,"student already exist...", Toast.LENGTH_LONG).show();

                }
                else if(response.body().getResponse().equals("error"))
                {
                    Toast.makeText(RegisterationActivity.this,"Something went wrong...", Toast.LENGTH_LONG).show();

                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
    public void register(View view) {
        id  = findViewById(R.id.txt_id);
        txtUsername  = findViewById(R.id.txt_user_name);
        txtPassword  = findViewById(R.id.txt_password);
        txtUserType  = findViewById(R.id.txt_user_type);
        average  = findViewById(R.id.txt_avg);

        registerUser(id.getText().toString(), txtUsername.getText().toString(),
                txtPassword.getText().toString(),txtUserType.getText().toString(),average.getText().toString());
        id.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txtUserType.setText("");
        average.setText("");

    }
}
