package com.example.doaamubdr.project;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.doaamubdr.project.data.Project;

import java.util.List;

public class projectsAdapter extends RecyclerView.Adapter<projectsAdapter.ProjectsViewHolder> {
    private Context mCtx;
    private List<Project> projectList;


    public projectsAdapter(Context mCtx, List<Project> projectList) {
        this.mCtx = mCtx;
        this.projectList = projectList;
    }

    @NonNull
    @Override
    public ProjectsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_projects, parent, false);
        return new ProjectsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectsViewHolder holder, final int position) {
         Project project= projectList.get(position);
        holder.textViewName.setText(project.getSupervisorName());
        holder.textViewProject.setText(project.getProjectName());

    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }


    class ProjectsViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewProject;
        String id;


        public ProjectsViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewProject = itemView.findViewById(R.id.textViewProject);

            itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     int pos = getAdapterPosition();

                     // check if item still exists
                     if (pos != RecyclerView.NO_POSITION) {
                         Project clickedDataItem = projectList.get(pos);
                           id =  clickedDataItem.getId();


                         Intent intent = new Intent(mCtx, briefActivity.class);
                         intent.putExtra("project_id", projectList.get(pos).getId());
                         intent.putExtra("supervisor_name", projectList.get(pos).getSupervisorName());
                         intent.putExtra("project_name", projectList.get(pos).getProjectName());
                         intent.putExtra("brief", projectList.get(pos).getBrief());
                         mCtx.startActivity(intent);

                     }

                 }
             });

        }

    }
}