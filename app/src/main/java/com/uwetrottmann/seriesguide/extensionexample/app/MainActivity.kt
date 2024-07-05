package com.uwetrottmann.seriesguide.extensionexample.app

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.battlelancer.seriesguide.api.Intents

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.buttonMainViewShow).setOnClickListener {
            // view show in SeriesGuide
            val intent = Intents.buildViewShowIntent(82856)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        findViewById<View>(R.id.buttonMainViewEpisode).setOnClickListener {
            // view episode in SeriesGuide
            val intent = Intents.buildViewEpisodeIntent(82856, 1, 2)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }

}
