package com.example.pgd_project_2021010619;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    FloatingActionButton button;
    String userName;

    public static ArrayList<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            userName = bundle.getString("user");
        }

        RecyclerView recyclerView = findViewById(R.id.recycle);
        PostAdapter adapter = new PostAdapter(posts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        button = findViewById(R.id.floatingButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, AddPost.class);
                intent.putExtra("user", userName);
                startActivity(intent);
            }
        });
    }
}