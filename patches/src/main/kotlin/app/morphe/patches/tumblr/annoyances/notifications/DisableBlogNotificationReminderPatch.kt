/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/6b06b9d1328b971a06d10b4247f4c10f050e4f61/patches/src/main/kotlin/app/revanced/patches/tumblr/annoyances/notifications/DisableBlogNotificationReminderPatch.kt
 */

package app.morphe.patches.tumblr.annoyances.notifications

import app.morphe.patches.shared.compat.AppCompatibilities
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.util.returnEarly

@Suppress("unused")
val disableBlogNotificationReminderPatch = bytecodePatch(
    name = "Disable blog notification reminder",
    description = "Disables the reminder to enable notifications for blogs you visit.",
) {
    compatibleWith(AppCompatibilities.TUMBLR)

    execute {
        IsBlogNotifyEnabledFingerprint.method.returnEarly(false)
    }
}

