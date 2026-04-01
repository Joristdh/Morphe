package app.morphe.patches.peacocktv.ads

import app.morphe.patcher.Fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

internal object MediaTailerAdServiceMethodFingerprint : Fingerprint(
    accessFlags = listOf(AccessFlags.PUBLIC),
    returnType = "Ljava/lang/Object;",
    strings = listOf("Could not build MT Advertising service"),
)

