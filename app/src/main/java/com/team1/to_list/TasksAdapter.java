package com.team1.to_list;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {

    private List mTasks;
    private Context mContext;

    public TasksAdapter(List mTasks, Context mContext) {
        this.mTasks = mTasks;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Nạp layout cho View biểu diễn phần tử Task
        View taskView =
                inflater.inflate(R.layout.taskitem, parent, false);

        return new ViewHolder(taskView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tasks task = (Tasks) mTasks.get(position);

        holder.titile.setText(task.getTitle());
        holder.deadline.setText(task.getDeadline());


    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public View itemView;
        public TextView titile;
        public TextView deadline;
        public Button detail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.itemView = itemView;

            addControls();

            addEvents();
        }

        private void addEvents() {
            detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Tasks tasks = (Tasks) mTasks.get(getAdapterPosition());

                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra("title", tasks.getTitle());
                    intent.putExtra("deadline", tasks.getDeadline());
                    intent.putExtra("content", tasks.getContent());
                    mContext.startActivity(intent);
                }
            });
        }

        private void addControls() {
            titile = this.itemView.<TextView>findViewById(R.id.textTitle);
            deadline = this.itemView.<TextView>findViewById(R.id.textDeadline);
            detail = this.itemView.<Button>findViewById(R.id.btnDetailTask);
        }
    }
}
