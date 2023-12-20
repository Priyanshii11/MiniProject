package com.example.miniproject.Parity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miniproject.Checksum.MainActivity;
import com.example.miniproject.R;

public class Parity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parity);
        getWindow().setStatusBarColor(Color.parseColor("#46BAA9"));
        getWindow().setNavigationBarColor(Color.parseColor("#ffffff"));

             Button pcorrupt = findViewById(R.id.PCrpt);
             Button pNOncrpt = findViewById(R.id.PNonCorrupted);
             EditText PSend = findViewById(R.id.Psender);

        //corrupt bit text
        pcorrupt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Pvalue = PSend.getText().toString();
                if (Pvalue.isBlank()){
                    PSend.setError("Enter the Text First");
                    Toast.makeText(Parity.this, "NO TEXT RECEIVED ", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Parity.this, Phackerside.class);
                    intent.putExtra("Text", Pvalue);
                    startActivity(intent);
                }

            }
        });


        //non corrupt text
        pNOncrpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Pvalue = PSend.getText().toString();
                if (Pvalue.isBlank()){
                    PSend.setError("Enter the Text First");
                    Toast.makeText(Parity.this, "NO TEXT RECEIVED ", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent1 = new Intent(Parity.this, Pnoncrpt.class);
                    intent1.putExtra("textp", Pvalue);
                    startActivity(intent1);
                }
            }
        });



    }
    //             String modifiedBinary = modifyBinary(Pbinary);

    //Function to add '0' if the number of ones is even, and '1' if it's odd
//    private static String modifyBinary(String binaryNumber) {
//        // Count the number of ones in the binary number
//        int numberOfOnes = 0;
//        for (char bit : binaryNumber.toCharArray()) {
//            if (bit == '1') {
//                numberOfOnes++;
//            }
//        }
//
//        // Check if the number of ones is even or odd
//        if (numberOfOnes % 2 == 0) {
//            // If even, add '0'
//            return binaryNumber + "0";
//        } else {
//            // If odd, add '1'
//            return binaryNumber + "1";
//        }
//    }


}