package com.uwetrottmann.seriesguide.extensionexample.app;

import com.battlelancer.seriesguide.api.SeriesGuideExtension;
import com.battlelancer.seriesguide.api.SeriesGuideExtensionReceiver;


public class ExampleExtensionReceiver extends SeriesGuideExtensionReceiver {
    @Override
    protected int getJobId() {
        return 1;
    }

    @Override
    protected Class<? extends SeriesGuideExtension> getExtensionClass() {
        return ExampleExtensionService.class;
    }
}
