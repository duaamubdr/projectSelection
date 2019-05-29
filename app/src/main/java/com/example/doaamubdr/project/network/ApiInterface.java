package com.example.doaamubdr.project.network;

import com.example.doaamubdr.project.data.Project;
import com.example.doaamubdr.project.data.Result;
import com.example.doaamubdr.project.data.User;
import com.example.doaamubdr.project.data.selection;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("register.php")
    Call<User> peformRegisteration(@Query("user_id") String id, @Query("user_name") String UserName, @Query("user_password") String UserPassword, @Query("userType") String UserType,@Query("average") String average);

    @GET("login.php")
    Call<User> peformUserLogin(@Query("user_name") String UserName, @Query("user_password") String UserPassword);

    @GET("supervisor.php")
    Call<Project> supervisor(@Query("supervisorName") String supervisorName, @Query("projectName") String projectName,@Query("brief") String brief);

    @GET("retrieveProject.php")
    Call<Project> getProjets();

    @GET("selection.php")
    Call<selection> performSelection(@Query("user_id")String user_id, @Query("project_id")int id1,
                                     @Query("pro_order")int order1);

    @GET("retrieveResult.php")
    Call<Result> getResults();
}

