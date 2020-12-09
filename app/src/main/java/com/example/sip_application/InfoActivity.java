package com.example.sip_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener{
        Button be;
        TextView tv;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.info_activity);
            int g = 1 + (int) (Math.random()*100);
            be = (Button) findViewById(R.id.buttonbuttonu);
            be.setOnClickListener(this);
            tv = (TextView) findViewById(R.id.textViewvb);
            tv.setText("Спасибо, что выбрали нас! Ваш заказ № " + g + ".");
        }

        public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        }
}
