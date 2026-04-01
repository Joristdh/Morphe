/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/377d4e15016296b45d809697f7f69bce74badd3a/patches/src/main/kotlin/app/revanced/patches/tiktok/misc/login/fixgoogle/FixGoogleLoginPatch.kt
 */

package app.morphe.patches.tiktok.misc.login.fixgoogle

import app.morphe.patches.shared.compat.AppCompatibilities
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch

@Suppress("unused")
val fixGoogleLoginPatch = bytecodePatch(
    name = "Fix Google login",
    description = "Allows logging in with a Google account. (Version pin not specified in this build.)",
) {
    compatibleWith(*AppCompatibilities.tiktokAny())

    execute {
        listOf(
            GoogleOneTapAuthAvailableFingerprint.method,
            GoogleAuthAvailableFingerprint.method,
        ).forEach { method ->
            method.addInstructions(
                0,
                """
                    const/4 v0, 0x0
                    return v0
                """,
            )
        }
    }
}

