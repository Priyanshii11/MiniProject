package com.example.miniproject.Parity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.miniproject.Checksum.CorrptBit;
import com.example.miniproject.Checksum.Hackerside;
import com.example.miniproject.R;

public class Phackerside extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phackerside);
        getWindow().setStatusBarColor(Color.parseColor("#46BAA9"));
        getWindow().setNavigationBarColor(Color.parseColor("#46BAA9"));


        @SuppressLint("MissingInflatedId") EditText Hacker_side_send = findViewById(R.id.Phackertext);
        @SuppressLint("MissingInflatedId") Button Psend_new_Text =findViewById(R.id.Phacksidesendbtn);
        @SuppressLint("MissingInflatedId") TextView sendText = findViewById(R.id.PsenderText);

        //show the old text
        String sent = getIntent().getStringExtra("Text");
        sendText.setText(sent);
        String oldText = sendText.getText().toString();


        Psend_new_Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = Hacker_side_send.getText().toString();

                Intent intent = new Intent(Phackerside.this, PcorrptActivity.class);
                intent.putExtra("new Text" , newText);
                intent.putExtra("old Text" , oldText);
                startActivity(intent);

            }
        });



    }
}