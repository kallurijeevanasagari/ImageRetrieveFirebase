package com.example.hp.imageretrievewithfirebase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Hp on 16-May-17.
 */
public class BlogViewHolder extends RecyclerView.ViewHolder {
    View mView;
    TextView textView_title;
    TextView textView_decription;
    ImageView imageView;
    public BlogViewHolder(View itemView) {
        super(itemView);
        mView=itemView;
        textView_title = (TextView)itemView.findViewById(R.id.title);
        textView_decription = (TextView) itemView.findViewById(R.id.description);
        imageView=(ImageView)itemView.findViewById(R.id.image);
    }
    public void setTitle(String title)
    {
        textView_title.setText(title+"");
    }
    public void setDescription(String description)
    {
        textView_decription.setText(description);
    }


    public void setImage(Context c, String image) {
        Picasso.with(c).load(image).into(imageView);
    }
}