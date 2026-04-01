/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/377d4e15016296b45d809697f7f69bce74badd3a/patches/src/main/kotlin/app/revanced/patches/tiktok/misc/login/fixgoogle/Fingerprints.kt
 */

package app.morphe.patches.tiktok.misc.login.fixgoogle

import app.morphe.patcher.Fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

internal object GoogleAuthAvailableFingerprint : Fingerprint(
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.FINAL),
    returnType = "Z",
    parameters = listOf(),
    definingClass = "Lcom/bytedance/lobby/google/GoogleAuth;",
)

internal object GoogleOneTapAuthAvailableFingerprint : Fingerprint(
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.FINAL),
    returnType = "Z",
    parameters = listOf(),
    definingClass = "Lcom/bytedance/lobby/google/GoogleOneTapAuth;",
)

