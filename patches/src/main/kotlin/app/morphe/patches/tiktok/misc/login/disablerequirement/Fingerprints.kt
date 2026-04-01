/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/377d4e15016296b45d809697f7f69bce74badd3a/patches/src/main/kotlin/app/revanced/patches/tiktok/misc/login/disablerequirement/Fingerprints.kt
 */

package app.morphe.patches.tiktok.misc.login.disablerequirement

import app.morphe.patcher.Fingerprint

internal object MandatoryLoginServiceFingerprint : Fingerprint(
    custom = { method, classDef ->
        classDef.endsWith("/MandatoryLoginService;") && method.name == "enableForcedLogin"
    },
)

internal object MandatoryLoginService2Fingerprint : Fingerprint(
    custom = { method, classDef ->
        classDef.endsWith("/MandatoryLoginService;") && method.name == "shouldShowForcedLogin"
    },
)

