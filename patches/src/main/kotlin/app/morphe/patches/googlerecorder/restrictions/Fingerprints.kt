package app.morphe.patches.googlerecorder.restrictions

import app.morphe.patcher.Fingerprint

internal object ApplicationOnCreateFingerprint : Fingerprint(
    name = "onCreate",
    definingClass = "Lcom/google/android/apps/recorder/RecorderApplication;",
    strings = listOf("com.google.android.feature.PIXEL_2017_EXPERIENCE"),
)

