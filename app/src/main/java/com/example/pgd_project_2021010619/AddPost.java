package com.example.pgd_project_2021010619;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPost extends AppCompatActivity {

    String userName;
    EditText storyText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            userName = bundle.getString("user");
        }

        storyText = findViewById(R.id.story);
        button = findViewById(R.id.submitButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = storyText.getText().toString();
                Post post = new Post(userName, text);
                Home.posts.add(post);
                Toast.makeText(AddPost.this, "Story added", Toast.LENGTH_SHORT).show();
                Intent homePage = new Intent(AddPost.this, Home.class);
                startActivity(homePage);
            }
        });

    }
}