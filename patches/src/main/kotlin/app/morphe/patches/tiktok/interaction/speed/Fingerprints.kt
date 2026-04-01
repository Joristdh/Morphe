/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/377d4e15016296b45d809697f7f69bce74badd3a/patches/src/main/kotlin/app/revanced/patches/tiktok/interaction/speed/Fingerprints.kt
 */

package app.morphe.patches.tiktok.interaction.speed

import app.morphe.patcher.Fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

internal object GetSpeedFingerprint : Fingerprint(
    custom = { method, classDef ->
        classDef.endsWith("/BaseListFragmentPanel;") && method.name == "onFeedSpeedSelectedEvent"
    },
)

internal object SetSpeedFingerprint : Fingerprint(
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.FINAL),
    returnType = "Ljava/lang/Object;",
    strings = listOf("playback_speed"),
    custom = { method, _ ->
        method.name == "invoke" && method.parameterTypes.isEmpty()
    },
)

