package com.example.organs_donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
        // Set OnClickListener for the Logout button
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Sign out the user from Firebase
                    FirebaseAuth.getInstance().signOut();

                    // Finish the current activity (homepage) after a short delay
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Create intent for the login page
                            Intent intent = new Intent(homepage.this, Login_Page.class);

                            // Add flags to clear the entire activity stack and create a new task
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                            // Start the login page activity
                            startActivity(intent);

                            // Finish the current activity (homepage)
                            finish();
                        }
                    }, 500); // Adjust the delay time if needed
                } catch (Exception e) {
                    e.printStackTrace();
                    // Handle any exceptions here
                }
            }
        });




    }
}
