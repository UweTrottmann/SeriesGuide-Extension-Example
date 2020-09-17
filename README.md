# SeriesGuide-Extension-Example

Example Android project using the SeriesGuide extension API.

This project is built with Gradle. Import the project in Android Studio using the `settings.gradle` file.

This work by [Uwe Trottmann](https://uwetrottmann.com) is licensed under the [Apache License 2.0](LICENSE.txt).

# How to build an extension for SeriesGuide

If added by the user in SeriesGuide, an extension can provide an action button shown below an episode or movie.

The button might link to external content (app deep-link, web page, ...) or trigger an action in another app (play, record, ...). Or it can just display some status information (e.g. "downloaded"). Have a look at the [available extensions on Google Play](https://play.google.com/store/search?q=SeriesGuide%20Extension&c=apps).

<img src="https://seriesgui.de/images/extensions-600x256.png" width="300" height="128" alt="Extensions examples" />

## Get started

<a href="https://search.maven.org/search?q=seriesguide-api"><img src="https://img.shields.io/maven-central/v/com.uwetrottmann.seriesguide/seriesguide-api.svg?style=flat-square"></a>

1. Add the API dependency to your Android project:
    ```
    implementation 'com.uwetrottmann.seriesguide:seriesguide-api:2.1.0'
    ```
    The artifact is published on Maven Central.

2. Create a new class that extends [`SeriesGuideExtension`](https://seriesgui.de/api/reference/com/battlelancer/seriesguide/api/SeriesGuideExtension.html) and overrides at least one of the `onRequest` methods.

3. Create a new class that extends [`SeriesGuideExtensionReceiver`](https://seriesgui.de/api/reference/com/battlelancer/seriesguide/api/SeriesGuideExtensionReceiver.html).

4. Add the required tags to your `AndroidManifest.xml` file. See [`AndroidManifest.xml` of the example app](https://github.com/UweTrottmann/SeriesGuide-Extension-Example/blob/main/app/src/main/AndroidManifest.xml).
   See the class documentation of [`SeriesGuideExtension`](https://seriesgui.de/api/reference/com/battlelancer/seriesguide/api/SeriesGuideExtension.html)
   for details and additional configuration, e.g. how to add a configuration activity.

    **When targeting Android 11 (SDK 30)** add `queries` tags to allow the extension to see the SeriesGuide app (learn about [package visiblity changes](https://developer.android.com/preview/privacy/package-visibility)):
    ```xml
    <manifest>
        <!-- When targeting SDK 30 (R), make the SeriesGuide app visible to this extension. -->
        <queries>
            <package android:name="com.battlelancer.seriesguide" />
            <package android:name="com.uwetrottmann.seriesguide.amzn" />
        </queries>
    </manifest>
    ```

Install your extension side-by-side with SeriesGuide. You should be able to add it from the extension customization screen.
The activity of this screen, `com.battlelancer.seriesguide.extensions.ExtensionsConfigurationActivity`,
is exported so your code can directly start it, e.g. to direct users to add your extension.

# How to deep link to a show or episode

Use the [`Intents`](https://github.com/UweTrottmann/SeriesGuide/blob/dev/api/src/main/java/com/battlelancer/seriesguide/api/Intents.java) class.
See the [`MainActivity`](app/src/main/java/com/uwetrottmann/seriesguide/extensionexample/app/MainActivity.java) class for examples.

# API Reference
Take a look at the [API reference documentation](https://seriesgui.de/api/reference) for additional details, for example to add a configuration screen for an extension.

# API change log

See the [SeriesGuide repository](https://github.com/UweTrottmann/SeriesGuide/blob/dev/api/CHANGELOG.md).
