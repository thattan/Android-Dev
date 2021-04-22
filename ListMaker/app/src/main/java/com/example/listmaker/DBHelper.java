package com.example.listmaker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "crud.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_LISTINSTANCE = "CREATE TABLE " + ListInstance.TABLE  + "("
                + ListInstance.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + ListInstance.KEY_listname + " TEXT, "
                + ListInstance.KEY_description + " TEXT)";

        db.execSQL(CREATE_TABLE_LISTINSTANCE);


        String CREATE_TABLE_LISTINSTANCERECORD = "CREATE TABLE " + ListInstanceRecord.TABLE  + "("
                + ListInstanceRecord.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + ListInstanceRecord.KEY_recordDescription + " TEXT)";

        db.execSQL(CREATE_TABLE_LISTINSTANCERECORD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ListInstance.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ListInstanceRecord.TABLE);

        onCreate(db);
    }
}
