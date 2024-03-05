package com.example.organs_donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        // Get references to the buttons
        Button donorButton = findViewById(R.id.DonarBTN);
        Button bloodDonorButton = findViewById(R.id.BloodDonarBTN);
        Button receiverButton = findViewById(R.id.reciverBTN);
        Button helpButton = findViewById(R.id.helpBTN);

        // Set OnClickListener for the Donor button
        donorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to the Donor activity
                Intent intent = new Intent(homepage.this, donorpage.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener for the Blood Donor button
        bloodDonorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to the Blood Donor activity
                Intent intent = new Intent(homepage.this, blooddonationpage.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener for the Receiver button
        receiverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to the Receiver activity
                Intent intent = new Intent(homepage.this, receiverhomepage.class);
                startActivity(intent);
            }
        });

    }
}