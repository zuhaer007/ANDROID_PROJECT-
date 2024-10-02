package com.example.innvision;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

class FormActivity extends AppCompatActivity {

    private EditText nameInput, emailInput, phoneInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Initialize Form Fields
        nameInput = findViewById(R.id.name_input);
        emailInput = findViewById(R.id.email_input);
        phoneInput = findViewById(R.id.phone_input);
    }
    private boolean validateForm() {
        String name = nameInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();
        String phone = phoneInput.getText().toString().trim();

        // Regex patterns
        Pattern namePattern = Pattern.compile("^[A-Za-z ]{3,}$");
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Pattern phonePattern = Pattern.compile("^[0-9]{10}$");

        if (!namePattern.matcher(name).matches()) {
            nameInput.setError("Invalid name (minimum 3 characters)");
            return false;
        }

        if (!emailPattern.matcher(email).matches()) {
            emailInput.setError("Invalid email address");
            return false;
        }

        if (!phonePattern.matcher(phone).matches()) {
            phoneInput.setError("Invalid phone number (10 digits)");
            return false;
        }

        return true;
    }
}

