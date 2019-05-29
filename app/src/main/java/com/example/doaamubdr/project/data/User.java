package com.example.doaamubdr.project.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {
    @SerializedName("response")
    private String response;

    public String getUser_id() {
        return user_id;
    }

    @SerializedName("user_id")
    private String user_id;

    @SerializedName("name")
    private String name;

    @SerializedName("userType")
    private  String userType;




    public String getResponse() {
        return response;
    }


    public String getName() {
        return name;
    }


    public String getUserType() {
        return userType;
    }



}
