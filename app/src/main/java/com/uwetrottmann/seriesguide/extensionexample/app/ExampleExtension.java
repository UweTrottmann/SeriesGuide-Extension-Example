package com.uwetrottmann.seriesguide.extensionexample.app;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.battlelancer.seriesguide.api.Action;
import com.battlelancer.seriesguide.api.Episode;
import com.battlelancer.seriesguide.api.Movie;
import com.battlelancer.seriesguide.api.SeriesGuideExtension;

public class ExampleExtension extends SeriesGuideExtension {

    public static final String TAG = "ExampleExtension";

    public ExampleExtension() {
        super("ExampleExtension");
    }

    @Override
    protected void onRequest(int episodeIdentifier, Episode episode) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onRequest: episode " + episode.toBundle().toString());
        }

        publishGoogleAction(episodeIdentifier, episode.getTitle());
    }

    @Override
    protected void onRequest(int movieIdentifier, Movie movie) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onRequest: movie " + movie.toBundle().toString());
        }

        publishGoogleAction(movieIdentifier, movie.getTitle());
    }

    private void publishGoogleAction(int identifier, String searchTerm) {
        publishAction(new Action.Builder("Example search", identifier)
                .viewIntent(new Intent(Intent.ACTION_VIEW)
                        .setData(Uri.parse("https://www.google.com/#q=" + searchTerm)))
                .build());
    }
}
