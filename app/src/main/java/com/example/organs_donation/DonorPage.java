package com.example.organs_donation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DonorPage extends AppCompatActivity {

    private EditText nameEditText, ageEditText, bloodGroupEditText, phoneEditText;

    private Toolbar bloodTB; // Corrected the variable name here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donorpage);

        // Initialize EditText fields
        nameEditText = findViewById(R.id.nameET);
        ageEditText = findViewById(R.id.ageET);
        bloodGroupEditText = findViewById(R.id.bloodGroupET);
        phoneEditText = findViewById(R.id.phoneET);

        Button saveButton = findViewById(R.id.saveBTN);
        Button editButton = findViewById(R.id.editBTN);
        Button submitButton = findViewById(R.id.submitBTN);
        bloodTB = findViewById(R.id.bloodTB); // Corrected the variable name here
        setSupportActionBar(bloodTB);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableEditTexts(true);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitData();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.blood_type_a_plus) {
            handleDropdownSelection("A+");
            return true;
        } else if (itemId == R.id.blood_type_b_plus) {
            handleDropdownSelection("B+");
            return true;
        } else if (itemId == R.id.blood_type_a_minus) {
            handleDropdownSelection("A-");
            return true;
        } else if (itemId == R.id.blood_type_b_minus) {
            handleDropdownSelection("B-");
            return true;
        } else if (itemId == R.id.blood_type_ab_plus) {
            handleDropdownSelection("AB+");
            return true;
        } else if (itemId == R.id.blood_type_ab_minus) {
            handleDropdownSelection("AB-");
            return true;
        } else if (itemId == R.id.blood_type_o_plus) {
            handleDropdownSelection("O+-");
            return true;
        } else if (itemId == R.id.blood_type_o_minus) {
            handleDropdownSelection("O-");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.blood_main, menu);
        return true;
    }

    private void handleDropdownSelection(String bloodType) {
        showToast(bloodType + " selected");
        bloodTB.setTitle(bloodType);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void saveData() {
        // Retrieve data from EditText fields
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String bloodGroup = bloodGroupEditText.getText().toString();
        String phone = phoneEditText.getText().toString();

        // Save the data using appropriate method (e.g., SharedPreferences, SQLite database, etc.)
        // For demonstration purpose, simply display a toast with the data
        String message = "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Blood Group: " + bloodGroup + "\n" +
                "Phone Number: " + phone;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void enableEditTexts(boolean enabled) {
        // Enable or disable EditText fields based on the 'enabled' parameter
        nameEditText.setEnabled(enabled);
        ageEditText.setEnabled(enabled);
        bloodGroupEditText.setEnabled(enabled);
        phoneEditText.setEnabled(enabled);
    }

    private void submitData() {
        // Perform data submission to a server or other backend system
        // For demonstration purpose, simply display a toast
        Toast.makeText(this, "Data submitted", Toast.LENGTH_SHORT).show();
    }
}
