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

        publishGoogleAction(episodeIdentifier, "tv?tmdb=${episode.tmdbId}&season=${episode.season}&episode=${episode.number}")
    }

    override fun onRequest(movieIdentifier: Int, movie: Movie) {
        if (BuildConfig.DEBUG) {
            Log.d(NAME, "onRequest: movie ${movie.toBundle()}")
        }

        publishGoogleAction(movieIdentifier, "movie?tmdb=${movie.tmdbId}")
    }

    private fun publishGoogleAction(identifier: Int, searchTerm: String) {
        publishAction(
            Action.Builder("Example search", identifier)
                .viewIntent(
                    Intent(Intent.ACTION_VIEW)
                        .setData(Uri.parse("https://vidsrc.xyz/embed/$searchTerm&ds_lang=bg"))
                )
                .build()
        )
    }

    companion object {
        const val NAME: String = "ExampleExtension"
    }
}
