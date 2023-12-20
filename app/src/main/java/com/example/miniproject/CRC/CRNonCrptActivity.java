package com.example.miniproject.CRC;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.miniproject.R;

public class CRNonCrptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crnon_crpt);
        getWindow().setStatusBarColor(Color.parseColor("#46BAA9"));
        getWindow().setNavigationBarColor(Color.parseColor("#ffffff"));

        TextView Ctext = findViewById(R.id.Crc1);
        TextView Cbin = findViewById(R.id.CRC2);
        TextView Pbit = findViewById(R.id.CRC3);
        TextView Preceived = findViewById(R.id.CRC4);

        //take value from Main Activity
        String Cmyvalue = getIntent().getStringExtra("crc");
        Ctext.setText(Cmyvalue);

        // call function
        String Crbinary = String.valueOf(convertStringToCRBinary(Cmyvalue));
        Cbin.setText(Crbinary);


    }
    public static StringBuilder convertStringToCRBinary (String text){
        StringBuilder get_result = new StringBuilder();
        char[] chars = text.toCharArray();
        for (char c : chars) {
            get_result.append(String.format("%8s", Integer.toBinaryString(c)));

        }
        return get_result;
    }
}