/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/377d4e15016296b45d809697f7f69bce74badd3a/patches/src/main/kotlin/app/revanced/patches/tiktok/misc/share/SanitizeShareUrlsPatch.kt
 */

package app.morphe.patches.tiktok.misc.share

import app.morphe.patches.shared.compat.AppCompatibilities
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.tiktok.misc.extension.sharedExtensionPatch

private const val EXTENSION_CLASS_DESCRIPTOR = "Lapp/morphe/extension/tiktok/share/ShareUrlSanitizer;"

@Suppress("unused")
val sanitizeShareUrlsPatch = bytecodePatch(
    name = "Sanitize sharing links",
    description = "Remove tracking parameters from shared links. (Supports TikTok 43.8.3 only.)",
) {
    dependsOn(sharedExtensionPatch)

    compatibleWith(*AppCompatibilities.tiktok4383())

    execute {
        ShareUrlShorteningFingerprint.method.apply {
            val longUrlRegister = implementation!!.registerCount - 6 + 3
            addInstructions(
                0,
                """
                    invoke-static/range { v$longUrlRegister .. v$longUrlRegister }, $EXTENSION_CLASS_DESCRIPTOR->sanitizeShareUrl(Ljava/lang/String;)Ljava/lang/String;
                    move-result-object v$longUrlRegister
                """,
            )
        }
    }
}

