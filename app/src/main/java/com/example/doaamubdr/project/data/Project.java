package com.example.doaamubdr.project.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;
public class Project {


    @SerializedName("response")
    private String response;

    @SerializedName("project_id")
    private String id;

    @SerializedName("supervisorName")
    private  String supervisorName;

    @SerializedName("projectName")
    private  String projectName;


    @SerializedName("brief")
    private  String brief;

    @SerializedName("projects")
    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public String getResponse() {
        return response;
    }

    public String getId() {
        return id;
    }
    public String getSupervisorName() {
        return supervisorName;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getBrief() {
        return brief;
    }

}
