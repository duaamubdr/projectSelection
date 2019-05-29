package com.example.doaamubdr.project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doaamubdr.project.data.Result;

import java.util.List;

public class resultsAdapter extends RecyclerView.Adapter<resultsAdapter.ResultViewHolder> {
    private Context mCtx;
    private List<Result> resultList;

    public resultsAdapter(Context mCtx, List<Result> resultList) {
        this.mCtx = mCtx;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_projects, viewGroup, false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder resultViewHolder, int i) {
        Result result = resultList.get(i);

        resultViewHolder.textViewStuName.setText(result.getStu_name());
        resultViewHolder.textViewProName.setText(result.getPro_name());
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    class ResultViewHolder extends RecyclerView.ViewHolder{
        TextView textViewStuName, textViewProName;

        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewStuName = itemView.findViewById(R.id.textViewName);
            textViewProName = itemView.findViewById(R.id.textViewProject);
        }
    }
}
