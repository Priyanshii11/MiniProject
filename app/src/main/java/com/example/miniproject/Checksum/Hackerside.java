package com.example.miniproject.Checksum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.miniproject.R;

public class Hackerside extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackerside);
        getWindow().setStatusBarColor(Color.parseColor("#46BAA9"));
        getWindow().setNavigationBarColor(Color.parseColor("#46BAA9"));


        EditText Hacker_side_send = findViewById(R.id.hackertext);
        Button send_new_Text =findViewById(R.id.hacksidesendbtn);
        TextView sendText = findViewById(R.id.senderText);

        //show the old text
        String sent = getIntent().getStringExtra("text");
        sendText.setText(sent);
        String oldText = sendText.getText().toString();




        send_new_Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = Hacker_side_send.getText().toString();

                Intent intent = new Intent(Hackerside.this, CorrptBit.class);
                intent.putExtra("new Text" , newText);
                intent.putExtra("old Text" , oldText);
                startActivity(intent);

            }
        });

    }
}