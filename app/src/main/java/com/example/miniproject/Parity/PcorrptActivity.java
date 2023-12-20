package com.example.miniproject.Parity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.miniproject.R;

public class PcorrptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcorrpt);
        getWindow().setStatusBarColor(Color.parseColor("#46BAA9"));
        getWindow().setNavigationBarColor(Color.parseColor("#46BAA9"));

        TextView Ptext = findViewById(R.id.PcText);
        TextView Pbin = findViewById(R.id.PCbit);
        TextView Pbit = findViewById(R.id.ParityR);
        TextView Preceived = findViewById(R.id.RecedP);

        String myoldval = getIntent().getStringExtra("old Text");
        String myoldbin = String.valueOf(convertStringToPBinary(myoldval));


        //take value from previous Activity
        String Pmyvalue = getIntent().getStringExtra("new Text");
        Ptext.setText(Pmyvalue);

        // call function
        String Pbinary = String.valueOf(convertStringToPBinary(Pmyvalue));
        Pbin.setText(Pbinary);

        //call function
        String ParityResult = concatenateBasedOnOnes(Pbinary);
        Pbit.setText(ParityResult);

        boolean isParityValid = checkEvenParity(ParityResult);
        if(myoldbin != Pbinary) {
            Preceived.setText("Data of old binary bit " + myoldbin + " of text '" + myoldval +"'"+
                    " not equals to Received one " + Pbinary + " of text '" + Pmyvalue+"'");
        }
        else {
            Preceived.setText("data is valid");
        }
    }

    public static StringBuilder convertStringToPBinary (String text){
        StringBuilder get_result = new StringBuilder();
        char[] chars = text.toCharArray();
        for (char c : chars) {
            get_result.append(String.format("%8s", Integer.toBinaryString(c)).replace(' ' , '0'));
        }
        return get_result;
    }

    private static String concatenateBasedOnOnes(String binaryString) {
        int numberOfOnes = countOnes(binaryString);

        // Concatenate '1' if the number of ones is odd, '0' if it's even
        char bitToConcatenate = (numberOfOnes % 2 == 1) ? '1' : '0';

        return binaryString + bitToConcatenate;
    }

    private static int countOnes(String binaryString) {
        // Count the number of '1's in the binary string
        int count = 0;
        for (char bit : binaryString.toCharArray()) {
            if (bit == '1') {
                count++;
            }
        }
        return count;
    }

    // Function to check even parity
    public static boolean checkEvenParity(String dataWithParity) {
        int countOnes = countOnes(dataWithParity);
        // If the count of ones is even, return true (parity check passed)
        return countOnes % 2 == 0;
    }


}