package com.team1.to_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    TasksAdapter tasksAdapter;
    ArrayList<Tasks> tasks;
    RecyclerView recyclerViewTasks;
    Button btnAdd;

    Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        addControls();

        addEvent();

        UpdateTasks(); // Cập nhật Task

    }

    private void UpdateTasks() {
        intent1 = getIntent();
        String add_title = intent1.getStringExtra("add_title");
        String add_deadline = intent1.getStringExtra("add_deadline");
        String add_content = intent1.getStringExtra("add_content");

        if(add_title != null){
            tasks.add(new Tasks(add_title, add_content, add_deadline));
        }

    }

    private void addEvent() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask();
            }
        });
    }

    private void addTask() {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    private void addControls() {
        tasks = new ArrayList<Tasks>();
        //Tự phát sinh 50 dữ liệu mẫu
        for (int i = 1; i <= 5; i++) {
            tasks.add(new Tasks("abc", "xyz", "01 - 12 - 2022"));
        }

        recyclerViewTasks = (RecyclerView)findViewById(R.id.recylerviewTasks_home);
        tasksAdapter = new TasksAdapter(tasks, this);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerViewTasks.setAdapter(tasksAdapter);
        recyclerViewTasks.setLayoutManager(linearLayoutManager);

        btnAdd = this.<Button>findViewById(R.id.btnAddTasks_home);
    }
}