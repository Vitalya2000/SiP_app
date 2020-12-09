package com.example.sip_application;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etLogin2;
    EditText etPassword2;
    MyDBHelper dbHelper2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);
        etLogin2 = (EditText) findViewById(R.id.editText4);
        etPassword2 = (EditText) findViewById(R.id.editText5);
        Button btn_s = (Button) findViewById(R.id.button4);
        btn_s.setOnClickListener(this);
        dbHelper2 = new MyDBHelper(this);
    }

    @Override
    public void onClick(View v) {
        String login2 = etLogin2.getText().toString();
        String password2 = etPassword2.getText().toString();
        SQLiteDatabase database2 = dbHelper2.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDBHelper.KEY_LOGIN, login2);
        contentValues.put(MyDBHelper.KEY_PASSWORD, password2);
        database2.insert(MyDBHelper.TABLE_DATA, null, contentValues);
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        dbHelper2.close();
    }

}