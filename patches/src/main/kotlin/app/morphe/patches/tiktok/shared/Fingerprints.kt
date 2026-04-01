/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/377d4e15016296b45d809697f7f69bce74badd3a/patches/src/main/kotlin/app/revanced/patches/tiktok/shared/Fingerprints.kt
 */

package app.morphe.patches.tiktok.shared

import app.morphe.patcher.Fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

internal object GetEnterFromFingerprint : Fingerprint(
    returnType = "Ljava/lang/String;",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.FINAL),
    parameters = listOf("Z"),
    custom = { method, classDef ->
        method.definingClass.endsWith("/BaseListFragmentPanel;") &&
            method.returnType == "Ljava/lang/String;" &&
            method.parameterTypes.size == 1 &&
            method.parameterTypes[0] == "Z"
    },
)

internal object OnRenderFirstFrameFingerprint : Fingerprint(
    strings = listOf("method_enable_viewpager_preload_duration"),
    custom = { _, classDef ->
        classDef.endsWith("/BaseListFragmentPanel;")
    },
)

