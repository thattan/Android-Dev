package com.example.weddingrsvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewRsvpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rsvp);
        TextView nameView = (TextView) findViewById(R.id.rsvpName);
        TextView yesNoView = (TextView) findViewById(R.id.txtAttendingYesNo);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        boolean yesNo = bundle.getBoolean("attending");
        String yesNoString = "No";

        if (yesNo == true) {
            yesNoString = "Yes";
        }

        nameView.setText(name);
        yesNoView.setText(yesNoString);
    }


    public void goHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}