/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/6b06b9d1328b971a06d10b4247f4c10f050e4f61/patches/src/main/kotlin/app/revanced/patches/rar/misc/annoyances/purchasereminder/HidePurchaseReminderPatch.kt
 */

package app.morphe.patches.rar.misc.annoyances.purchasereminder

import app.morphe.patches.shared.compat.AppCompatibilities
import app.morphe.patcher.extensions.InstructionExtensions.addInstruction
import app.morphe.patcher.patch.bytecodePatch

@Suppress("unused")
val hidePurchaseReminderPatch = bytecodePatch(
    name = "Hide purchase reminder",
    description = "Hides the popup that reminds you to purchase the app.",
) {
    compatibleWith(AppCompatibilities.RAR)

    execute {
        ShowReminderFingerprint.method.addInstruction(0, "return-void")
    }
}

