package com.example.organs_donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class blooddonationpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blooddonationhomepage);

        Button aPositiveButton = findViewById(R.id.aPositive);
        Button aNegativeButton = findViewById(R.id.aNegative);
        Button bPositiveButton = findViewById(R.id.bPositive);
        Button bNegativeButton = findViewById(R.id.bNegative);
        Button abPositiveButton = findViewById(R.id.abPositive);
        Button abNegativeButton = findViewById(R.id.abNegative);
        Button oPositiveButton = findViewById(R.id.oPositive);
        Button oNegativeButton = findViewById(R.id.oNegative);

        aPositiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, new a_postivefrag())
                        .commit();
            }
        });

        aNegativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, new a_negativefrag())
                        .commit();
            }
        });

        bPositiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(blooddonationpage.this, B_PositiveList.class);
                startActivity(intent);
            }
        });

        bNegativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(blooddonationpage.this, B_NegativeList.class);
                startActivity(intent);
            }
        });

        abPositiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(blooddonationpage.this, AB_PositiveList.class);
                startActivity(intent);
            }
        });

        abNegativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(blooddonationpage.this, AB_NegativeList.class);
                startActivity(intent);
            }
        });

        oPositiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, new o_positivefrag())
                        .commit();

            }
        });

        oNegativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, new o_negativefrag())
                        .commit();

            }
        });
    }
}