/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/6b06b9d1328b971a06d10b4247f4c10f050e4f61/patches/src/main/kotlin/app/revanced/patches/amazon/DeepLinkingPatch.kt
 */

package app.morphe.patches.amazon

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.shared.compat.AppCompatibilities

@Suppress("unused")
val deepLinkingPatch = bytecodePatch(
    name = "Always allow deep-linking",
    description = "Open Amazon links, even if the app is not set to handle Amazon links.",
) {
    compatibleWith(AppCompatibilities.AMAZON_SHOPPING)

    execute {
        DeepLinkingFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """,
        )
    }
}
