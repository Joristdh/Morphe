/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/6b06b9d1328b971a06d10b4247f4c10f050e4f61/patches/src/main/kotlin/app/revanced/patches/inshorts/ad/InshortsAdsPatch.kt
 */

package app.morphe.patches.inshorts.ad

import app.morphe.patches.shared.compat.AppCompatibilities
import app.morphe.patcher.extensions.InstructionExtensions.addInstruction
import app.morphe.patcher.patch.bytecodePatch

@Suppress("unused")
val hideAdsPatch = bytecodePatch(
    name = "Hide ads",
) {
    compatibleWith(AppCompatibilities.INSHORTS)

    execute {
        InshortsAdsFingerprint.method.addInstruction(
            0,
            "return-void",
        )
    }
}
