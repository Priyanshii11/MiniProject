package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setNavigationBarColor(Color.parseColor("#ffffff"));
        getWindow().setStatusBarColor(Color.parseColor("#ffffff"));

        TextView TXT = findViewById(R.id.txt);
        ImageView image = findViewById(R.id.card);

        Animation animation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.top);
//        Animation animation2 = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.top);


        image.startAnimation(animation);
//        TXT.startAnimation(animation2);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, ChooseTechniqueActivity.class));
                finish();
            }
        }, 2300);
    }
}