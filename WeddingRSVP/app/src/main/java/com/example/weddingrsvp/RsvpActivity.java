package com.example.weddingrsvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RsvpActivity extends AppCompatActivity {

    String name;
    boolean attending;
    EditText txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsvp);
        txtName = (EditText) findViewById(R.id.txtName);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void submitRsvp(View view) {

        RadioButton yesButton = (RadioButton) findViewById(R.id.rbtnYes);
        RadioButton noButton = (RadioButton) findViewById(R.id.rbtnNo);
        boolean error = false;
        if (yesButton.isChecked()) {
            attending = true;
        } else if (noButton.isChecked()) {
            attending = false;
        } else {
            error = true;
            displayToast("Attending option is required.");
        }

        name = txtName.getText().toString();

        if (name.equals("") || name == null) {
            error = true;
            displayToast("Name is required.");
        }

        if (error == false) {
            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            bundle.putBoolean("attending", attending);
            Intent intent = new Intent(this, ViewRsvpActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }
}