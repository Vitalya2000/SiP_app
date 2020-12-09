package com.example.sip_application;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_front;
    MyDBHelper4 dbHelper3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        btn_front = (Button) findViewById(R.id.button_front);
        btn_front.setOnClickListener(this);

        dbHelper3 = new MyDBHelper4(this);
    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase database2 = dbHelper3.getWritableDatabase();
        ContentValues contentValues2 = new ContentValues();

        database2.delete(MyDBHelper4.TABLE_INSTR, null, null);

        contentValues2.put(MyDBHelper4.KEY_NAME, "ПЕРФОРАТОР");
        contentValues2.put(MyDBHelper4.KEY_PRICE, 850.45);
        contentValues2.put(MyDBHelper4.KEY_TIME, "6 месяцев");
        contentValues2.put(MyDBHelper4.KEY_QUAN, 34);

        database2.insert(MyDBHelper4.TABLE_INSTR, null, contentValues2);

        contentValues2.put(MyDBHelper4.KEY_NAME, "Молоток");
        contentValues2.put(MyDBHelper4.KEY_PRICE, 15.22);
        contentValues2.put(MyDBHelper4.KEY_TIME, "2 недели");
        contentValues2.put(MyDBHelper4.KEY_QUAN, 45);

        database2.insert(MyDBHelper4.TABLE_INSTR, null, contentValues2);

        contentValues2.put(MyDBHelper4.KEY_NAME, "Ножовка");
        contentValues2.put(MyDBHelper4.KEY_PRICE, 100.22);
        contentValues2.put(MyDBHelper4.KEY_TIME, "8 месяцев");
        contentValues2.put(MyDBHelper4.KEY_QUAN, 11);

        database2.insert(MyDBHelper4.TABLE_INSTR, null, contentValues2);

        dbHelper3.close();
        Intent intent = new Intent(this, Store_Front.class);
        startActivity(intent);
    }
}
