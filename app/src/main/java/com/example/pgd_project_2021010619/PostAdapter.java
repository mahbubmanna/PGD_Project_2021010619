package com.example.pgd_project_2021010619;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pgd_project_2021010619.Post;
import com.example.pgd_project_2021010619.R;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{

    private ArrayList<Post> posts;

    public PostAdapter(ArrayList<Post> posts){
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View items = layoutInflater.inflate(R.layout.story, parent, false);
        return new ViewHolder(items);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.authorView.setText(post.getUserName());
        holder.textView.setText(post.getStory());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView authorView;
        public TextView textView;
        public LinearLayout postLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.authorView = (TextView) itemView.findViewById(R.id.author);
            this.textView = (TextView) itemView.findViewById(R.id.story);
            postLayout = (LinearLayout) itemView.findViewById(R.id.postLayout);
        }
    }
}
