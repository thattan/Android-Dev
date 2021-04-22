package com.example.listmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCreateList = (Button) findViewById(R.id.btnAddListItem);
        Button btLists = (Button) findViewById(R.id.btnViewList);

//        // GO TO CREATE LIST PAGE
//        btCreateList.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, CreateListActivity.class));
//            }
//        });

        // GO TO ALL LISTS
        btLists.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, ListsActivity.class));
            }
        });

    }

    public void launchCreateListActivity(View view) {
        Intent intent = new Intent(this, CreateListActivity.class);
        startActivity(intent);
    }
}