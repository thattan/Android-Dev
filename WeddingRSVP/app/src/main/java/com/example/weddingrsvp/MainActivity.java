package com.example.weddingrsvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        song = new MediaPlayer();
        song = MediaPlayer.create(this, R.raw.song);
    }

    public void launchSeeAllActivity(View view) {
        Intent intent = new Intent(this, SeeAllActivity.class);
        startActivity(intent);
    }

    public void launchRsvpActivity(View view) {
        Intent intent = new Intent(this, RsvpActivity.class);
        startActivity(intent);
    }

    public void playSong(View view) {
        song.start();
    }
}