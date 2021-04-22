package com.example.listmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ListsActivity extends ListActivity implements android.view.View.OnClickListener{

    String[] listItems;
    String[] listItemDescriptions;
    Button btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);
        Intent intent = getIntent();
        listItems = intent.getStringArrayExtra("listItems");
        listItemDescriptions = intent.getStringArrayExtra("listItemDescriptions");
        btnRefresh = (Button) findViewById(R.id.btnRefresh);
        btnRefresh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v== findViewById(R.id.btnRefresh)){
            if (listItems.length != 0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        Intent objIndent = new Intent(getApplicationContext(),CreateListActivity.class);
                        objIndent.putExtra("position", position);
                        startActivity(objIndent);
                    }
                });
            } else {
                Toast.makeText(this,"No List Items",Toast.LENGTH_SHORT).show();
            }
        }
    }
}