package com.example.organs_donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        // Get references to the buttons
        TextView donorButton = findViewById(R.id.DonarTV);
        TextView bloodDonorButton = findViewById(R.id.BloodDonarTV);
        TextView receiverButton = findViewById(R.id.receiverTV);
        Button helpButton = findViewById(R.id.helpBTN);
        Button logoutButton = findViewById(R.id.logoutBTN);

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

        // Set OnClickListener for the Logout button
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Redirect to the Login activity and clear back stack
                    Intent intent = new Intent(homepage.this, Login_Page.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    // Handle any exceptions here
                }
            }
        });

    }
}
