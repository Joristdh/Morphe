/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/6b06b9d1328b971a06d10b4247f4c10f050e4f61/patches/src/main/kotlin/app/revanced/patches/disneyplus/ads/SkipAdsPatch.kt
 */

package app.morphe.patches.disneyplus.ads

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.shared.compat.AppCompatibilities

@Suppress("unused")
val skipAdsPatch = bytecodePatch(
    name = "Skip ads",
    description = "Automatically skips ads.",
) {
    compatibleWith(AppCompatibilities.DISNEY_PLUS)

    execute {
        arrayOf(InsertionGetPointsFingerprint, InsertionGetRangesFingerprint).forEach {
            it.method.addInstructions(
                0,
                """
                    new-instance v0, Ljava/util/ArrayList;
                    invoke-direct { v0 }, Ljava/util/ArrayList;-><init>()V
                    return-object v0
                """.trimIndent(),
            )
        }
    }
}

