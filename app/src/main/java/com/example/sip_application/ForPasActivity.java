package com.example.sip_application;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ForPasActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etLogin3;
    EditText etPassword3;
    MyDBHelper dbHelper3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forpas_activity);
        etLogin3 = (EditText) findViewById(R.id.editText6);
        etPassword3 = (EditText) findViewById(R.id.editText7);
        Button btn_f = (Button) findViewById(R.id.button5);
        btn_f.setOnClickListener(this);
        dbHelper3 = new MyDBHelper(this);
    }

    @Override
    public void onClick(View v) {
        String login2 = etLogin3.getText().toString();
        String password2 = etPassword3.getText().toString();
        SQLiteDatabase database2 = dbHelper3.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDBHelper.KEY_LOGIN, login2);
        contentValues.put(MyDBHelper.KEY_PASSWORD, password2);
        database2.insert(MyDBHelper.TABLE_DATA, null, contentValues);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        dbHelper3.close();
    }

}
