package com.example.miniproject.CRC;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.miniproject.Parity.Parity;
import com.example.miniproject.Parity.PcorrptActivity;
import com.example.miniproject.R;

public class CRC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crc);

        getWindow().setStatusBarColor(Color.parseColor("#46BAA9"));
        getWindow().setNavigationBarColor(Color.parseColor("#ffffff"));


        Button button = findViewById(R.id.CRCrpt);
        Button button2 = findViewById(R.id.CrNonCorrupted);

          EditText editText2 = findViewById(R.id.CRsender);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CrVal = editText2.getText().toString();
                Intent intent = new Intent(CRC.this, CRcorptActivity.class);
                intent.putExtra("crc" , CrVal);
                startActivity(intent);

            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CrVal1 = editText2.getText().toString();
                Intent intent2 = new Intent(CRC.this, CRNonCrptActivity.class);
                intent2.putExtra("crc!" , CrVal1);
                startActivity(intent2);
            }
        });



    }

    }

