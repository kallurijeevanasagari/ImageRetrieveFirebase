package com.example.hp.imageretrievewithfirebase;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference myref;
    private FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        database= FirebaseDatabase.getInstance();
        myref=database.getReference().child("/blog");

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Blog,BlogViewHolder> recyclerAdapter=new FirebaseRecyclerAdapter<Blog,BlogViewHolder>(
                Blog.class,
                R.layout.individual_row,
                BlogViewHolder.class,
                myref) {
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, Blog model, int position) {
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDescription(model.getDescription());
                viewHolder.setImage(getApplicationContext(),model.getImage());
            }
        };
        recyclerView.setAdapter(recyclerAdapter);
    }


}