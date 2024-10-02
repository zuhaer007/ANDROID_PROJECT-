package com.example.innvision;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView appName, seekbarValue;
    private ImageView hotelImage;
    private CheckBox agreeTermsCheckbox;
    private RadioGroup radioGroup;
    private RadioButton radioSingle, radioDouble;
    private RatingBar ratingBar;
    private SeekBar seekBar;
    private Switch switchNotifications;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        appName = findViewById(R.id.app_name);
        hotelImage = findViewById(R.id.hotel_image);
        agreeTermsCheckbox = findViewById(R.id.agree_terms_checkbox);
        radioGroup = findViewById(R.id.radio_group);
        radioSingle = findViewById(R.id.radio_single);
        radioDouble = findViewById(R.id.radio_double);
        ratingBar = findViewById(R.id.rating_bar);
        seekBar = findViewById(R.id.seek_bar);
        seekbarValue = findViewById(R.id.seekbar_value);
        switchNotifications = findViewById(R.id.switch_notifications);
        submitButton = findViewById(R.id.submit_button);

        // SeekBar Change Listener
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarValue.setText(progress + " night(s)");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Submit Button Click Listener
        submitButton.setOnClickListener(v -> {
            // Show Toast message when submit is clicked
            StringBuilder summary = new StringBuilder("Booking Summary:\n");

            // CheckBox (Terms)
            if (agreeTermsCheckbox.isChecked()) {
                summary.append("Agreed to Terms\n");
            } else {
                summary.append("Did not agree to Terms\n");
            }

            // RadioButton (Room Type)
            int selectedRoomId = radioGroup.getCheckedRadioButtonId();
            if (selectedRoomId == R.id.radio_single) {
                summary.append("Room: Single Room\n");
            } else if (selectedRoomId == R.id.radio_double) {
                summary.append("Room: Double Room\n");
            }

            // RatingBar (Rating)
            summary.append("Rating: ").append(ratingBar.getRating()).append("\n");

            // SeekBar (Stay Duration)
            summary.append("Nights: ").append(seekBar.getProgress()).append("\n");

            // Switch (Notifications)
            if (switchNotifications.isChecked()) {
                summary.append("Notifications: Enabled\n");
            } else {
                summary.append("Notifications: Disabled\n");
            }

            // Show Toast with booking summary
            Toast.makeText(MainActivity.this, summary.toString(), Toast.LENGTH_LONG).show();
        });
    }
}


