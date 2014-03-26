package com.uwetrottmann.seriesguide.extensionexample.app;

import android.content.Intent;
import android.net.Uri;
import com.battlelancer.seriesguide.api.Action;
import com.battlelancer.seriesguide.api.Episode;
import com.battlelancer.seriesguide.api.SeriesGuideExtension;

public class ExampleExtension extends SeriesGuideExtension {

    public ExampleExtension() {
        super("ExampleExtension");
    }

    @Override
    protected void onRequest(int episodeIdentifier, Episode episode) {
        publishAction(new Action.Builder("Google search", episodeIdentifier)
                .viewIntent(new Intent(Intent.ACTION_VIEW)
                        .setData(Uri.parse("https://www.google.com/#q="
                                + episode.getTitle())))
                .build());
    }

}
