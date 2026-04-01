/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/6b06b9d1328b971a06d10b4247f4c10f050e4f61/patches/src/main/kotlin/app/revanced/patches/strava/password/EnablePasswordLoginPatch.kt
 */

package app.morphe.patches.strava.password

import app.morphe.patches.shared.compat.AppCompatibilities
import app.morphe.patcher.Fingerprint
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.util.returnEarly

@Suppress("unused")
val enablePasswordLoginPatch = bytecodePatch(
    name = "Enable password login",
    description = "Re-enables password login after having used an OTP code.",
) {
    compatibleWith(AppCompatibilities.STRAVA)

    execute {
        fun Fingerprint.returnTrue() = method.returnEarly(true)

        LogInGetUsePasswordFingerprint.returnTrue()
        EmailChangeGetUsePasswordFingerprint.returnTrue()
    }
}

