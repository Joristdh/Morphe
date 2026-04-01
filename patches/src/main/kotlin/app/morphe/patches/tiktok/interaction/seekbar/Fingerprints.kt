/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/377d4e15016296b45d809697f7f69bce74badd3a/patches/src/main/kotlin/app/revanced/patches/tiktok/interaction/seekbar/Fingerprints.kt
 */

package app.morphe.patches.tiktok.interaction.seekbar

import app.morphe.patcher.Fingerprint

internal object SetSeekBarShowTypeFingerprint : Fingerprint(
    strings = listOf("seekbar show type change, change to:"),
)

internal object ShouldShowSeekBarFingerprint : Fingerprint(
    strings = listOf("can not show seekbar, state: 1, not in resume"),
)

