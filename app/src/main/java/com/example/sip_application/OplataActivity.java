package com.example.sip_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OplataActivity extends AppCompatActivity implements View.OnClickListener{
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oplata_activity);
        Button b = (Button) findViewById(R.id.buttonconfirm);
        b.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }
}
