package com.example.sip_application;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper4 extends SQLiteOpenHelper {
public static final int DATABASE_VERSION = 10;
public static final String DATABASE_NAME = "DBTools";
public static final String TABLE_INSTR = "INSTR";
public static final String KEY_ID = "ID";
public static final String KEY_NAME = "NAME";
public static final String KEY_PRICE = "PRICE";
public static final String KEY_TIME = "TIME";
public static final String KEY_QUAN = "QUAN";
//public static final String KEY_YQUAN = "YQUAN";
//public static final String KEY_YPR = "YPR";

public MyDBHelper4(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

@Override
public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_INSTR + "(" + KEY_ID + " integer primary key," + KEY_NAME + " text," + KEY_PRICE + " float," + KEY_TIME + " text," + KEY_QUAN + " integer" + ")");
        }

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_INSTR);
        onCreate(db);
        }
        }
