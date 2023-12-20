package com.example.miniproject.Checksum;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.miniproject.R;

public class CorrptBit extends AppCompatActivity {

    TextView Sender_side_oldbinary, sent_oldtext, Receiver_side_newtext, receiver_side_newsum, crptresult;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrpt_bit);

        getWindow().setStatusBarColor(Color.parseColor("#46BAA9"));
        getWindow().setNavigationBarColor(Color.parseColor("#46BAA9"));


        // lind all the text boxes
        Sender_side_oldbinary = findViewById(R.id.sendersideoldsum);
        sent_oldtext = findViewById(R.id.sentoldText);
        Receiver_side_newtext = findViewById(R.id.recieversidenewtext);
        receiver_side_newsum = findViewById(R.id.receiversidenewsum);
        crptresult = findViewById(R.id.resultcrpt);

//      new connverted binary text
        String NEWTextreceived = getIntent().getStringExtra("new Text");
        Receiver_side_newtext.setText(NEWTextreceived);

        //      new connverted binary sum receiver side
        String csumnew = calculateBinaryChecksum(NEWTextreceived);
        receiver_side_newsum.setText(csumnew);


        //      sender values
        String sentold = getIntent().getStringExtra("old Text");
        sent_oldtext.setText(sentold);

        //calculate binary sum
        String csumold = calculateBinaryChecksum(sentold);
        Sender_side_oldbinary.setText(csumold);


        // set result
        String result = result(csumold,csumnew);
        crptresult.setText(result);


///     to show 1's Complement of the Binary sum of sender side
        TextView ONECOMNEw = findViewById(R.id.ONEsNewCom);
        String onescomplementNew = onesComplemtment(csumold);
        ONECOMNEw.setText(onescomplementNew);

        TextView ADDBIN = findViewById(R.id.AdditonNew);
        String addNewSUM = Sumtwonew(onescomplementNew , csumnew);
        String compleNEw = onesComplemtment(addNewSUM);
        ADDBIN.setText(" Here Addition of both sender and receiver side sum = " +addNewSUM + " and then it's Complement is = " + compleNEw);


    }

    private String onesComplemtment(String csumold) {
        StringBuilder onesComplement = new StringBuilder();

        // Iterate through each character in the binary number
        for (char bit : csumold.toCharArray()) {
            // Toggle 0s to 1s and 1s to 0s
            onesComplement.append((bit == '0') ? '1' : '0');
        }

        return onesComplement.toString();


    }

    private String Sumtwonew(String onescomplement, String receiver_side_newsum) {
        int maxLength = Math.max(onescomplement.length(), receiver_side_newsum.length());
        StringBuilder result = new StringBuilder();
        int carry = 0;

        // Iterate through the binary numbers from right to left
        for (int i = 0; i < maxLength; i++) {
            int bit1 = i < onescomplement.length() ? Character.getNumericValue(onescomplement.charAt(onescomplement.length() - 1 - i)) : 0;
            int bit2 = i < receiver_side_newsum.length() ? Character.getNumericValue(receiver_side_newsum.charAt(receiver_side_newsum.length() - 1 - i)) : 0;

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

    private String result(String csumold, String csumnew) {
        if (csumold.equals(csumnew)){
            return "Data is Not Corrupted but Confidentiality is Lost";
        }else{
            return  "Data is Corrupted";
        }
    }

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



}