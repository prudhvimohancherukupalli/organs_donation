package com.example.organs_donation;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DonorView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DonorAdapter donorAdapter;
    private List<Donor> donorList;
    private DatabaseReference databaseReference;
    private String selectedOrgan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donor_view);

        // Retrieve the selected organ from the intent that started this activity
        selectedOrgan = getIntent().getStringExtra("selectedOrgan");

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.DonorView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize Donor list
        donorList = new ArrayList<>();

        // Initialize DonorAdapter with showButtons parameter set to true
        donorAdapter = new DonorAdapter(this, donorList, true,false);

        // Set adapter to RecyclerView
        recyclerView.setAdapter(donorAdapter);

        // Load donors
        loadDonors();
    }

    private void loadDonors() {
        // Initialize Firebase Database
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        // Initialize database reference for the selected organ type
        if (selectedOrgan != null) {
            DatabaseReference databaseReference = firebaseDatabase.getReference("donors").child(selectedOrgan.toLowerCase() + "Donors");

            // Query to retrieve donors from Firebase
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    // Iterate through dataSnapshot to append new donors to the existing list
                    for (DataSnapshot donorSnapshot : dataSnapshot.getChildren()) {
                        Donor donor = donorSnapshot.getValue(Donor.class);
                        donorList.add(donor);
                    }

                    // Notify adapter of data change
                    donorAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle database error
                    Toast.makeText(DonorView.this, "Failed to load donors: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            // Handle error if selectedOrgan is null
            Toast.makeText(DonorView.this, "Selected organ is null", Toast.LENGTH_SHORT).show();
        }
    }
}
