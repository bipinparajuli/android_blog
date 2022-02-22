package com.example.travelblog;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class BlogDetails extends AppCompatActivity {

//    public static final String IMAGE_URL =
//            "https://bitbucket.org/dmytrodanylyk/travel-blog-resources/raw/" +
//                    "3436e16367c8ec2312a0644bebd2694d484eb047/images/sydney_image.jpg";
//    public static final String AVATAR_URL =
//            "https://bitbucket.org/dmytrodanylyk/travel-blog-resources/raw/" +
//                    "3436e16367c8ec2312a0644bebd2694d484eb047/avatars/avatar1.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_details);

        ImageView imageMain = findViewById(R.id.imageMain);
        imageMain.setImageResource(R.drawable.sydney_image);
//        Glide.with(this).load(IMAGE_URL).into(imageMain);


        ImageView imageAvatar = findViewById(R.id.imageAvatar);
        imageAvatar.setImageResource(R.drawable.avatar);
//        Glide.with(this).load(AVATAR_URL).into(imageAvatar);


        TextView textTitle = findViewById(R.id.textTitle);
        textTitle.setText("G'day from Nepal");

        TextView textDate = findViewById(R.id.textDate);
        textDate.setText("Feb, 25,2022");

        TextView textAuthor = findViewById(R.id.textAuthor);
        textAuthor.setText("Bipin Parajuli");

        TextView textRating = findViewById(R.id.textRating);
        textRating.setText("4.4");

        TextView textViews = findViewById(R.id.textViews);
        textViews.setText("403 Views");

        TextView textDescription = findViewById(R.id.textDescription);
        textDescription.setText("Nepal is one of most beautiful Country in the world, so it has been best tourist destination so long");

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(4.4f);

        ImageView imageBack = findViewById(R.id.imageWhite);
        imageBack.setOnClickListener(v -> finish());
        




    }
}
