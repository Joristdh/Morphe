/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/377d4e15016296b45d809697f7f69bce74badd3a/patches/src/main/kotlin/app/revanced/patches/tiktok/misc/share/Fingerprints.kt
 */

package app.morphe.patches.tiktok.misc.share

import app.morphe.patcher.Fingerprint

internal object ShareUrlShorteningFingerprint : Fingerprint(
    returnType = "V",
    parameters = listOf(
        "L",
        "Ljava/lang/String;",
        "Ljava/util/List;",
        "Ljava/lang/String;",
        "Z",
        "I",
    ),
    strings = listOf("share_link_id", "invitation_scene"),
    custom = { method, _ ->
        method.parameterTypes.size == 6
    },
)

