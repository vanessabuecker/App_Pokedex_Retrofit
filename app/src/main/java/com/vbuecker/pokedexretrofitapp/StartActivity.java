package com.vbuecker.pokedexretrofitapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    TextView textView;
    SharedPreferences sharedpreferences;
    public static final String mypref = "mypref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_starting);

        Runnable r = new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(StartActivity.this, MainActivity.class));
                finish();
            }
        };

        SharedPreferences sharedpreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        textView = findViewById(R.id.name_textView_show);
        String name = sharedpreferences.getString("name", "");


        Handler h = new Handler();
        // The Runnable will be executed after the given delay time
        h.postDelayed(r, 3000); // will be delayed for 3 seconds


        new CountDownTimer(4000, 1000) {

            public void onTick(long millisUntilFinished) {
                textView.setText("Welcome, \n" + name + "! \n\nStarting your Pokedex in...  " + millisUntilFinished / 1000);

            }

            @Override
            public void onFinish() {

            }

        }.start();
    }
}