package com.example.sip_application;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class Store_Front extends AppCompatActivity implements View.OnClickListener {

    ViewPager2 pager;
    RecyclerView.Adapter pagerAdapter;
    MyDBHelper4 dbHelper4;
    TextView textViewk, textViewp;
    Button buttoni, buttono;
    int k;
    double p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_front);
        textViewk = (TextView)findViewById(R.id.textViewmykol);
        textViewp = (TextView)findViewById(R.id.textViewmyprice);
        buttoni= (Button) findViewById(R.id.buttonf);
        buttoni.setOnClickListener(this);
        buttono= (Button) findViewById(R.id.buttonp);
        buttono.setOnClickListener(this);


        dbHelper4 = new MyDBHelper4(this);
        SQLiteDatabase db = dbHelper4.getReadableDatabase();
        Cursor c = db.query("INSTR", null, null, null, null, null, null);

        pager = findViewById(R.id.pager);
        pagerAdapter = new MyPagerAdapter(c, dbHelper4);
        pager.setAdapter(pagerAdapter);


        k = 3;
        p = 850.45*k/2;
        textViewk.setText("Ваше количество инструментов: " + k);
        textViewp.setText("Ваша итоговая цена: " + p);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonf:
                Toast toast = Toast.makeText(getApplicationContext(),
                        "ДОБАВЛЕНО В ИЗБРАННОЕ", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.buttonp:
                Intent intent3 = new Intent(this, OplataActivity.class);
                startActivity(intent3);
                break;
        }
    }


}
