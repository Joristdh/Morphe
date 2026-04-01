package app.morphe.patches.shared.meta.ads

import app.morphe.patcher.Fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

/**
 * Upstream (ReVanced) fingerprint: SponsoredContentController.insertItem
 *
 * Threads Hide Ads / Twitch ad patches rely on this shared method that returns Z.
 */
internal object AdInjectorMethodFingerprint : Fingerprint(
    accessFlags = listOf(AccessFlags.PRIVATE),
    returnType = "Z",
    parameters = listOf("L", "L"),
    custom = { method, classDef ->
        method.name == "insertItem" && classDef.type.endsWith("/SponsoredContentController;")
    },
)

