package com.example.innvision;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

class ButtonActivity extends AppCompatActivity {

    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        // Initialize Button
        submitButton = findViewById(R.id.submit_button);

        // Submit Button Click Listener
        submitButton.setOnClickListener(v -> {
            // Action to perform on button click
            Toast.makeText(ButtonActivity.this, "Button clicked!", Toast.LENGTH_SHORT).show();
        });
    }
}
