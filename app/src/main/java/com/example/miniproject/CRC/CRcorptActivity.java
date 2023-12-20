package com.example.miniproject.CRC;

import static com.example.miniproject.Parity.Pnoncrpt.convertStringToPBinary;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.miniproject.R;

public class CRcorptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crcorpt);
        getWindow().setStatusBarColor(Color.parseColor("#46BAA9"));
        getWindow().setNavigationBarColor(Color.parseColor("#ffffff"));

        TextView CCtext = findViewById(R.id.CR1);
        TextView CCbin = findViewById(R.id.CR2);
//        TextView Pbit = findViewById(R.id.CR3);
//        TextView Preceived = findViewById(R.id.CR4);


        //take value from Main Activity
        String Cmyvalue = getIntent().getStringExtra("crc!");
        CCtext.setText(Cmyvalue);

        // call function
        String Crbinary = String.valueOf(convertStringToCRCBinary(Cmyvalue));
        CCbin.setText(Crbinary);

    }

    public static StringBuilder convertStringToCRCBinary(String text) {
        StringBuilder get_result = new StringBuilder();
        char[] chars = text.toCharArray();
        for (char c : chars) {
            get_result.append(String.format("%8s", Integer.toBinaryString(c)));

        }
        return get_result;
    }
}