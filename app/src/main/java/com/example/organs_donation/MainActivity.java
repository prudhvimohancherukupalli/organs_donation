package com.example.organs_donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    Button logInBTN;
    Button registerBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logInBTN = findViewById(R.id.logInBTN);
        registerBTN = findViewById(R.id.registerBTN);
        logInBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(MainActivity.this, homepage.class);
                startActivity(ini);
            }
        });
        registerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(MainActivity.this,Register_Page.class);
                startActivity(ini);
            }
        });
    }
}