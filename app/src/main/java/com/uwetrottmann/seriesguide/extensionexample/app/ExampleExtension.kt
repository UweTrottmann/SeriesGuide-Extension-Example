package com.uwetrottmann.seriesguide.extensionexample.app

import com.battlelancer.seriesguide.api.SeriesGuideExtension

/**
 * Optional: Original [SeriesGuideExtension] subclass, now subclass of
 * [ExampleExtensionService] for backwards compatibility with API v1.
 *
 * Technically we could re-use the existing [SeriesGuideExtension] subclass. But as it is now
 * a subclass of [androidx.core.app.JobIntentService] (previously [android.app.IntentService])
 * it requires the BIND_JOB_SERVICE permission on Android O+.
 * This would prevent SeriesGuide from starting the service. So we register [ExampleExtensionService]
 * separately and keep the original service component for this class in the manifest.
 */
class ExampleExtension : ExampleExtensionService()
