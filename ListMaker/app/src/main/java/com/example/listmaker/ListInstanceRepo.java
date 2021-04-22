package com.example.listmaker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListInstanceRepo {
    private DBHelper dbHelper;

    public ListInstanceRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(ListInstance li) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ListInstance.KEY_listname, li.listName);
        values.put(ListInstance.KEY_description, li.description);

        long listID = db.insert(ListInstance.TABLE, null, values);
        db.close();
        return (int) listID;
    }

    public ArrayList<HashMap<String, String>> getListInstanceList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                ListInstance.KEY_ID + "," +
                ListInstance.KEY_listname + "," +
                ListInstance.KEY_description +
                " FROM " + ListInstance.TABLE;

        //Student student = new Student();
        ArrayList<HashMap<String, String>> listList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> li = new HashMap<String, String>();
                li.put("id", cursor.getString(cursor.getColumnIndex(ListInstance.KEY_ID)));
                li.put("listName", cursor.getString(cursor.getColumnIndex(ListInstance.KEY_listname)));
                li.put("description", cursor.getString(cursor.getColumnIndex(ListInstance.KEY_description)));
                listList.add(li);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listList;

    }

}
