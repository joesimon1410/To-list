package com.team1.to_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    Button btnAdd;
    EditText title, deadline, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().hide();

        addControls();

        addEvents();
    }

    private void addEvents() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddActivity.this, HomeActivity.class);
                intent.putExtra("add_title", title.getText().toString());
                intent.putExtra("add_deadline", deadline.getText().toString());
                intent.putExtra("add_content", content.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }

    private void addControls() {
        btnAdd = this.<Button>findViewById(R.id.btnAdd_add);
        title = this.<EditText>findViewById(R.id.edtextTitle_add);
        deadline = this.<EditText>findViewById(R.id.edtextDeadline_add);
        content = this.<EditText>findViewById(R.id.edtextContent_add);


    }
}