package com.example.sip_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etLogin;
    EditText etPassword;
    MyDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLogin = (EditText) findViewById(R.id.editText1);
        etPassword = (EditText) findViewById(R.id.editText2);

        Button btn_enter = (Button) findViewById(R.id.buttona);
        btn_enter.setOnClickListener(this);

        Button btn_signin = (Button) findViewById(R.id.buttonb);
        btn_signin.setOnClickListener(this);

        Button btn_forpas = (Button) findViewById(R.id.buttonc);
        btn_forpas.setOnClickListener(this);

        dbHelper = new MyDBHelper(this);

    }

    @Override
    public void onClick(View v) {

        String login = etLogin.getText().toString();
        String password = etPassword.getText().toString();


        SQLiteDatabase database2 = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        switch (v.getId()) {
            case R.id.buttona:
                    contentValues.put(MyDBHelper.KEY_LOGIN, "Admin");
                    contentValues.put(MyDBHelper.KEY_PASSWORD, "4rfgh");
                    database2.insert(MyDBHelper.TABLE_DATA, null, contentValues);
                    Intent intent = new Intent(this, SecondActivity.class);
                    startActivity(intent);

                break;

            case R.id.buttonb:
                Intent intent2 = new Intent(this, SigninActivity.class);
                startActivity(intent2);
                break;

            case R.id.buttonc:
                Intent intent3 = new Intent(this, ForPasActivity.class);
                startActivity(intent3);
                break;

        }

        dbHelper.close();
    }
}
