package com.uwetrottmann.seriesguide.extensionexample.app;

import android.content.Intent;
import android.os.Bundle;

import com.battlelancer.seriesguide.api.Intents;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonMainViewShow).setOnClickListener(v -> {
            // view show in SeriesGuide
            Intent intent = Intents.buildViewShowIntent(82856);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });

        findViewById(R.id.buttonMainViewEpisode).setOnClickListener(v -> {
            // view episode in SeriesGuide
            Intent intent = Intents.buildViewEpisodeIntent(82856, 1, 2);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });
    }
}
