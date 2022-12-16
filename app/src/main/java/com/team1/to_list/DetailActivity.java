package com.team1.to_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

    EditText title, deadline, content;
    Button btnEdit, btnSave;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();

        intent = getIntent();

        addControls();

        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        title = this.<EditText>findViewById(R.id.edtextTitle_detail);
        title.setText(intent.getStringExtra("title"));

        deadline = this.<EditText>findViewById(R.id.edtextDeadline_detail);
        deadline.setText(intent.getStringExtra("deadline"));

        content = this.<EditText>findViewById(R.id.edtextContent_detail);
        content.setText(intent.getStringExtra("content"));
    }
}