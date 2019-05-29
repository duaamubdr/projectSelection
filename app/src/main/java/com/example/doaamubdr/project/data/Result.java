package com.example.doaamubdr.project.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {


    @SerializedName("stu_name")
    private String stu_name;

    @SerializedName("pro_id")
    private String pro_id;

    @SerializedName("pro_name")
    private String pro_name;


    public String getStu_name() {
        return stu_name;
    }

    public String getPro_id() {
        return pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    @SerializedName("result")
    private List<Result> result;

    public List<Result> getResult() {
        return result;
    }
}
