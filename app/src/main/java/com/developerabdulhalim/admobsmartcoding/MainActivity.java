package com.developerabdulhalim.admobsmartcoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.developerabdulhalim.admobsmartcoding.ads.Admob;
import com.developerabdulhalim.admobsmartcoding.ads.MainApp;
import com.google.android.gms.ads.FullScreenContentCallback;

public class MainActivity extends AppCompatActivity {

    Button button;

    private int adClickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

      /*  button.setOnClickListener(v -> {

            // ad Showing here=====================
            if (Admob.interstitialAd != null){
                Admob.interstitialAd.show(MainActivity.this);

                // Ad Dissmiss================================
                Admob.interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent();

                        // After ad is close wiil ad load again====================
                        Admob.interstitialAd =null;
                        Admob.loadAd(MainActivity.this);



                    }
                });

            }else {
                Toast.makeText(this, "Ad Not Loaded", Toast.LENGTH_SHORT).show();
            }

        });*/




        button.setOnClickListener(v -> {

            // ad Showing here=====================
            if (Admob.interstitialAd != null) {
                Admob.interstitialAd.show(MainActivity.this);
            } else {
                adClickCount = 0; // Reset the click counter
                Toast.makeText(this, " Clicked", Toast.LENGTH_SHORT).show();
            }

            if (Admob.interstitialAd != null) {
                Admob.interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent();

                        // Increment the ad click counter
                        adClickCount++;

                        // If the ad was clicked twice, hide the ad view
                        if (adClickCount == 1) {
                            button.setVisibility(View.GONE);
                            Admob.interstitialAd.show(MainActivity.this);

                        }

                        // Show the result activity if the ad was not clicked twice
                        if (adClickCount < 2) {

                        }
                    }
                });
            }



        });







    }
}