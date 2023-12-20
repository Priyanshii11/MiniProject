package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RadioButton;

import com.example.miniproject.Checksum.MainActivity;



import de.hdodenhof.circleimageview.CircleImageView;

public class ChooseTechniqueActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_technique);
        getWindow().setStatusBarColor(Color.parseColor("#46BAA9"));
        getWindow().setNavigationBarColor(Color.parseColor("#ffffff"));



        CircleImageView circleImageView = findViewById(R.id.circle_imageView);
        RadioButton Checksum = findViewById(R.id.csum);
        RadioButton Parity = findViewById(R.id.Parity);
        RadioButton CRC = findViewById(R.id.CRC);

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseTechniqueActivity.this, MyActivity.class);
                startActivity(intent);
            }
        });


        Checksum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseTechniqueActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Parity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseTechniqueActivity.this, com.example.miniproject.Parity.Parity.class);
                startActivity(intent);
            }
        });
        CRC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseTechniqueActivity.this, com.example.miniproject.CRC.CRC.class);
                startActivity(intent);
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu1, menu);
//            return true;
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.more) {
//            gotoUrl("https://www.geeksforgeeks.org/error-detection-in-computer-networks/");
//        }else
//        {
//            Intent intent = new Intent(ChooseTechniqueActivity.this, MyActivity.class);
//
//        }
//        return super.onOptionsItemSelected(item);
//
//
//    }


    }
