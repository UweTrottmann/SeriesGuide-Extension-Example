package com.uwetrottmann.seriesguide.extensionexample.app

import android.content.Intent
import android.net.Uri
import android.util.Log
import com.battlelancer.seriesguide.api.Action
import com.battlelancer.seriesguide.api.Episode
import com.battlelancer.seriesguide.api.Movie
import com.battlelancer.seriesguide.api.SeriesGuideExtension

open class ExampleExtensionService : SeriesGuideExtension(NAME) {

    private fun getFormattedSearchTerm(template: String, movie: Movie? = null, episode: Episode? = null): String {
    return template
        .replace("{movie.title}", movie?.title ?: "")
        .replace("{movie.tmdbId}", movie?.tmdbId?.toString() ?: "")
        .replace("{episode.title}", episode?.title ?: "")
        .replace("{episode.showTmdbId}", episode?.showTmdbId?.toString() ?: "")
        .replace("{episode.number}", episode?.number?.toString() ?: "")
        .replace("{episode.season}", episode?.season?.toString() ?: "")
        .replace("{episode.showTitle}", episode?.showTitle ?: "")
        .replace("{episode.absoluteNumber}", episode?.absoluteNumber ?: "")
    }

    override fun onRequest(movieIdentifier: Int, movie: Movie) {
        if (BuildConfig.DEBUG) {
            Log.d(NAME, "onRequest: movie ${movie.toBundle()}")
        }

        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val template = sharedPreferences.getString("saved_text", "https://google.com/search?q={movie.title}") ?: "default search"
        val searchTerm = getFormattedSearchTerm(template, movie = movie)

        publishGoogleAction(movieIdentifier, searchTerm)
    }

    override fun onRequest(episodeIdentifier: Int, episode: Episode) {
        if (BuildConfig.DEBUG) {
            Log.d(NAME, "onRequest: episode ${episode.toBundle()}")
        }
    
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val template = sharedPreferences.getString("saved_text", "https://google.com/search?q={episode.showTitle) S{episode.season}E{episode.absoluteNumber}") ?: "default search"
        val searchTerm = getFormattedSearchTerm(template, episode = episode)
    
        publishGoogleAction(episodeIdentifier, searchTerm)
    }

    private fun publishGoogleAction(identifier: Int, searchTerm: String) {
        publishAction(
            Action.Builder("custom search", identifier)
                .viewIntent(
                    Intent(Intent.ACTION_VIEW)
                        .setData(Uri.parse(searchTerm))
                )
                .build()
        )
    }

    companion object {
        const val NAME: String = "ExampleExtension"
    }
}
