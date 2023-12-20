package com.example.miniproject.Checksum;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miniproject.R;


public class MainActivity extends AppCompatActivity {

    EditText sender;
    Button send,reset;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(Color.parseColor("#46BAA9"));
        getWindow().setNavigationBarColor(Color.parseColor("#ffffff"));


        sender = findViewById(R.id.Csendertxt);
        send = findViewById(R.id.Csenderbtn);
        reset = findViewById(R.id.Creset);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sender.setText(" ");
            }
        });
    }

    public void click (View view){

        String value = sender.getText().toString();
            if (value.isBlank()) {
                sender.setError("Enter the Text First");
                Toast.makeText(MainActivity.this, "NO TEXT RECEIVED ", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, Result.class);
                intent.putExtra("result", value);
                startActivity(intent);
            }
        }

    }



