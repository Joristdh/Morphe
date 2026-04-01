/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/80ff578e21fce1b9825f2f7820d8d910e85f8822/patches/src/main/kotlin/app/revanced/patches/amznmusic/misc/extension/ExtensionPatch.kt
 * https://github.com/ReVanced/revanced-patches/blob/80ff578e21fce1b9825f2f7820d8d910e85f8822/patches/src/main/kotlin/app/revanced/patches/amznmusic/misc/extension/Hooks.kt
 */

package app.morphe.patches.amznmusic.misc.extension

import app.morphe.patcher.Fingerprint
import app.morphe.patches.shared.misc.extension.ExtensionHook
import app.morphe.patches.shared.misc.extension.sharedExtensionPatch

internal object MusicHomeActivityOnCreateFingerprint : Fingerprint(
    custom = { method, classDef ->
        method.name == "onCreate" && classDef.endsWith("/MusicHomeActivity;")
    },
)

private val applicationInitHook = ExtensionHook(
    fingerprint = MusicHomeActivityOnCreateFingerprint,
)

val sharedExtensionPatch = sharedExtensionPatch(
    extensionName = "amznmusic",
    isYouTubeOrYouTubeMusic = false,
    applicationInitHook,
)

