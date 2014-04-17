package com.uwetrottmann.seriesguide.extensionexample.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.battlelancer.seriesguide.api.Intents;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonMainViewShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // view show in SeriesGuide
                Intent intent = Intents.buildViewShowIntent(248835);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        findViewById(R.id.buttonMainViewEpisode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // view episode in SeriesGuide
                Intent intent = Intents.buildViewEpisodeIntent(248835, 4164086);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
