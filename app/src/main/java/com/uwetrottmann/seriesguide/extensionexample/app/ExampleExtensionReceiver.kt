package com.uwetrottmann.seriesguide.extensionexample.app

import com.battlelancer.seriesguide.api.SeriesGuideExtension
import com.battlelancer.seriesguide.api.SeriesGuideExtensionReceiver

class ExampleExtensionReceiver : SeriesGuideExtensionReceiver() {

    override fun getJobId(): Int = 1

    override fun getExtensionClass(): Class<out SeriesGuideExtension?> =
        ExampleExtensionService::class.java

}
