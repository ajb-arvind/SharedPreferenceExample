package com.official19.ajb.sharedpreferenceexample;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!new SaveUser(SplashActivity.this).getUser()) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
                else
                {
                    startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
                    finish();
                }
            }
        }, 1500);
    }
}
