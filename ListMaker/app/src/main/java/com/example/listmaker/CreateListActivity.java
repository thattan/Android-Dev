package com.example.listmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class CreateListActivity extends AppCompatActivity implements android.view.View.OnClickListener {

    List<String> testList = new ArrayList<String>();
    String[] listItems = new String[10];
    String[] listItemDescriptions = new String[10];
    String listItemName;
    String listItemDescription;
    Button btnCreateListItem;
    EditText txtListName;
    EditText txtListDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);


        txtListName = (EditText) findViewById(R.id.txtListName);
        txtListDescription = (EditText) findViewById(R.id.txtListDescription);
        btnCreateListItem = (Button) findViewById(R.id.btnCreateListItem);
        btnCreateListItem.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btnCreateListItem)) {
            listItemName = txtListName.getText().toString();
            listItemDescription = txtListDescription.getText().toString();

            int listLength = listItems.length;
            testList.add(listItemName);
            listItems[listLength] = listItemName;
            listItemDescriptions[listLength] = listItemDescription;
            Intent intent = new Intent(this, ListsActivity.class);
            intent.putExtra("listItems", listItems);
            intent.putExtra("listItemDescriptions", listItemDescriptions);
            startActivity(intent);
        }
    }
}