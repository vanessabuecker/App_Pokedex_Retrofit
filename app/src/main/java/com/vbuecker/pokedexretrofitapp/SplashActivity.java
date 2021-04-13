package com.vbuecker.pokedexretrofitapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView = findViewById(R.id.imageView);


        Runnable r = new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this, com.vbuecker.pokedexretrofitapp.User_Interface.class));
                finish();
            }
        };


        Handler h = new Handler();
        // The Runnable will be executed after the given delay time
        h.postDelayed(r, 3000); // will be delayed for 3 seconds


        new CountDownTimer(3000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}