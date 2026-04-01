/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/6b06b9d1328b971a06d10b4247f4c10f050e4f61/patches/src/main/kotlin/app/revanced/patches/messenger/inputfield/DisableTypingIndicatorPatch.kt
 */

package app.morphe.patches.messenger.inputfield

import app.morphe.patches.shared.compat.AppCompatibilities
import app.morphe.patcher.extensions.InstructionExtensions.replaceInstruction
import app.morphe.patcher.patch.bytecodePatch

@Suppress("unused")
val disableTypingIndicatorPatch = bytecodePatch(
    name = "Disable typing indicator",
    description = "Disables the indicator while typing a message.",
) {
    compatibleWith(AppCompatibilities.MESSENGER)

    execute {
        SendTypingIndicatorFingerprint.method.replaceInstruction(0, "return-void")
    }
}
