package com.example.sip_application;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MyDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Mydb";
    public static final String TABLE_DATA = "Data";
    public static final String KEY_ID = "ID";
    public static final String KEY_LOGIN = "LOGIN";
    public static final String KEY_PASSWORD = "PASSWORD";
    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_DATA + "(" + KEY_ID + " integer primary key," + KEY_LOGIN + " text," + KEY_PASSWORD + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_DATA);
        onCreate(db);
    }
}
