package com.developerabdulhalim.admobsmartcoding;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.developerabdulhalim.admobsmartcoding.ads.MainApp;

public class SplashActivity extends MainApp {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        },2000);
    }
}