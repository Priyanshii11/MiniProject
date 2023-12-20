package com.example.miniproject.Checksum;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.miniproject.R;

public class Result extends AppCompatActivity {

    TextView senderText;
    TextView ascii;
    TextView binaryTextBox;
    Button btn1, btn2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        getWindow().setStatusBarColor(Color.parseColor("#46BAA9"));
        getWindow().setNavigationBarColor(Color.parseColor("#46BAA9"));

        senderText = findViewById(R.id.senderText);
        ascii = findViewById(R.id.AsciiCode);
        binaryTextBox = findViewById(R.id.binaryNum);
        btn2 = findViewById(R.id.btn2);
        btn1 = findViewById(R.id.btn1);
        TextView sum = findViewById(R.id.sum);


        //take value from Main Activity
        String myvalue = getIntent().getStringExtra("result");
        senderText.setText(myvalue);

        // change text to STring
        String text = senderText.getText().toString();


        //call function to convert binary code
        String result = String.valueOf(convertStringToBinary(text));
        binaryTextBox.setText(result);


        //call function for Ascii code
        String Ascii_result = String.valueOf(Asciicode(text));
        ascii.setText(Ascii_result);

        String csum = calculateBinaryChecksum(myvalue);
        sum.setText(csum);


           //corrupt bit
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Result.this, Hackerside.class);
                    intent.putExtra("text",text);
                    startActivity(intent);
                }
            });


            // non corrupt bit
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Result.this, NonCorptRes.class);
                    intent.putExtra("text", myvalue);
                    intent.putExtra("binary sum", csum);
                    startActivity(intent);
                }
            });
    }




        // Method to calculate the binary checksum (sum of binary numbers)
        private static String calculateBinaryChecksum (String text){
            int checksum = 0;

            // Iterate through each character in the input text
            for (char c : text.toCharArray()) {
                // Convert each character to its 8-digit binary code
                String binaryCode = String.format("%8s", Integer.toBinaryString(c))
                        .replace(' ', '0');

                // Add the binary code to the checksum
                checksum += Integer.parseInt(binaryCode, 2);
            }

            // Convert the final checksum to binary representation
            return Integer.toBinaryString(checksum);
        }

        ///convert to its Ascii code
        public static StringBuilder Asciicode (String string){
            StringBuilder Ascii_result = new StringBuilder();
            char[] chars = string.toCharArray();
            for (char c : chars) {
                Ascii_result.append(
                        String.format("%5s", Integer.valueOf(c)));
            }
            return Ascii_result;
        }


        // convert result to binary
        public static StringBuilder convertStringToBinary (String text){
            StringBuilder get_result = new StringBuilder();
            char[] chars = text.toCharArray();
            for (char c : chars) {
                get_result.append(String.format("%8s", Integer.toBinaryString(c)));
            }
            return get_result;
        }
    }





