package com.example.android.notes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = " NotesManager";
    private static final String TABLE_NOTES = "Notes";
    private static final String KEY_ID = "id";
    private static final String KEY_Name = "notes";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME ,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NOTES_TABLE = "CREATE_TABLE" + TABLE_NOTES + "INTEGER PRIMARY KEY" + KEY_Name + "TEXT" + "}";
        sqliteDatabase.execSQL(CREATE_NOTES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }
    long addNotes (String note)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Con
    }
}
