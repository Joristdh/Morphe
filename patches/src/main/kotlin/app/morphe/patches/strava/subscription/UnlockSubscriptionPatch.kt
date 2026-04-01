/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/6b06b9d1328b971a06d10b4247f4c10f050e4f61/patches/src/main/kotlin/app/revanced/patches/strava/subscription/UnlockSubscriptionPatch.kt
 */

package app.morphe.patches.strava.subscription

import app.morphe.patches.shared.compat.AppCompatibilities
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.util.returnEarly

@Suppress("unused")
val unlockSubscriptionPatch = bytecodePatch(
    name = "Unlock subscription features",
    description = "Unlocks \"Routes\", \"Matched Runs\" and \"Segment Efforts\".",
) {
    compatibleWith(AppCompatibilities.STRAVA)

    execute {
        GetSubscribedFingerprint.method.returnEarly(true)
    }
}

