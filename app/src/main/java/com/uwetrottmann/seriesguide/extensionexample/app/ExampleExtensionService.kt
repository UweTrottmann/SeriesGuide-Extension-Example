package com.uwetrottmann.seriesguide.extensionexample.app

import android.content.Intent
import android.net.Uri
import android.util.Log
import com.battlelancer.seriesguide.api.Action
import com.battlelancer.seriesguide.api.Episode
import com.battlelancer.seriesguide.api.Movie
import com.battlelancer.seriesguide.api.SeriesGuideExtension

open class ExampleExtensionService : SeriesGuideExtension(NAME) {

    override fun onRequest(episodeIdentifier: Int, episode: Episode) {
        if (BuildConfig.DEBUG) {
            Log.d(NAME, "onRequest: episode ${episode.toBundle()}")
        }

        publishGoogleAction(episodeIdentifier, episode.title)
    }

    override fun onRequest(movieIdentifier: Int, movie: Movie) {
        if (BuildConfig.DEBUG) {
            Log.d(NAME, "onRequest: movie ${movie.toBundle()}")
        }

        publishGoogleAction(movieIdentifier, movie.title)
    }

    private fun publishGoogleAction(identifier: Int, searchTerm: String) {
        publishAction(
            Action.Builder("Example search", identifier)
                .viewIntent(
                    Intent(Intent.ACTION_VIEW)
                        .setData(Uri.parse("https://www.google.com/#q=$searchTerm"))
                )
                .build()
        )
    }

    companion object {
        const val NAME: String = "ExampleExtension"
    }
}
