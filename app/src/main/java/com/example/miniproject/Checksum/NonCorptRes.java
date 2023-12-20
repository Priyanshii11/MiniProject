package com.example.miniproject.Checksum;


import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.miniproject.R;

public class NonCorptRes extends AppCompatActivity {

    TextView Sender_side_binary, sent_text, Receiver_side_text, receiver_side_sum, result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noncorptres);

        getWindow().setStatusBarColor(Color.parseColor("#46BAA9"));
        getWindow().setNavigationBarColor(Color.parseColor("#46BAA9"));


        // lind all the text boxes
        Sender_side_binary = findViewById(R.id.sendersidesum);
        sent_text = findViewById(R.id.sentText);
        Receiver_side_text = findViewById(R.id.recieversidetext);
        receiver_side_sum = findViewById(R.id.receiversidesum);
        result = findViewById(R.id.result);

        //take value from previous activity and set on the textbox
        //this box is of the text which store the text from  sender side
        String sentText = getIntent().getStringExtra("text");
        sent_text.setText(sentText);

        //take value from previous activity and set on the textbox
        //this box is of the sum of the binary number which is calculated on sender side
        String check_sum = getIntent().getStringExtra("binary sum");
        Sender_side_binary.setText(check_sum);


        // take the value to change the text into string to check the receiver side
        String text = getIntent().getStringExtra("text");
        Receiver_side_text.setText(text);

        String Reiceversum = calculateBinaryChecksum(text);
        receiver_side_sum.setText(Reiceversum);

        //call function to check whether the sender text same or not
        String resultFinal = calculateStringtext(text, sentText);
        result.setText(resultFinal);

///     to show 1's Complement of the Binary sum of sender side
        TextView ONECOM = findViewById(R.id.ONEsCom);
        String onescomplement = onesComplemt(check_sum);
        ONECOM.setText(onescomplement);

        TextView ADDBIN = findViewById(R.id.Additon);
        String addSUM = SumtTwo(onescomplement , Reiceversum);
        String compleNEw = onesComplemt(addSUM);
        ADDBIN.setText(" Here Addition of both sender and receiver side sum = " +addSUM + " means no error , "+ "and then it's Complement is = " + compleNEw);

    }


    private String SumtTwo(String onescomplement, String reiceversum) {
        int maxLength = Math.max(onescomplement.length(), reiceversum.length());
        StringBuilder result = new StringBuilder();
        int carry = 0;

        // Iterate through the binary numbers from right to left
        for (int i = 0; i < maxLength; i++) {
            int bit1 = i < onescomplement.length() ? Character.getNumericValue(onescomplement.charAt(onescomplement.length() - 1 - i)) : 0;
            int bit2 = i < reiceversum.length() ? Character.getNumericValue(reiceversum.charAt(reiceversum.length() - 1 - i)) : 0;

            int sum = bit1 + bit2 + carry;

            // Append the sum bit to the result
            result.insert(0, sum % 2);

            // Calculate the carry for the next iteration
            carry = sum / 2;
        }

        // If there's a carry left, append it to the result
        if (carry > 0) {
            result.insert(0, carry);
        }

        return result.toString();
    }



    private String onesComplemt(String Check_Sum) {

        StringBuilder onesComplement = new StringBuilder();

        // Iterate through each character in the binary number
        for (char bit : Check_Sum.toCharArray()) {
            // Toggle 0s to 1s and 1s to 0s
            onesComplement.append((bit == '0') ? '1' : '0');
        }

        return onesComplement.toString();


    }

    // Method to calculate the binary checksum (sum of binary numbers)
    private static String calculateBinaryChecksum(String text) {
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


    // method to check where the sender or receiver text are same or not
    private static String calculateStringtext(String sent, String receiver) {
        String result = null;
        if (sent.equals(receiver)) {
            result = "No Error Detected here";
        }
        return result;

    }
}