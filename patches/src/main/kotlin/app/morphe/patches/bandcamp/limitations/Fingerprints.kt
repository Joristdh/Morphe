package app.morphe.patches.bandcamp.limitations

import app.morphe.patcher.Fingerprint

internal object HandlePlaybackLimitsFingerprint : Fingerprint(
    strings = listOf("track_id", "play_count"),
)

