package app.morphe.patches.googlerecorder.restrictions

import app.morphe.patches.shared.compat.AppCompatibilities
import app.morphe.patcher.extensions.InstructionExtensions.addInstruction
import app.morphe.patcher.extensions.InstructionExtensions.getInstruction
import app.morphe.patcher.extensions.InstructionExtensions.removeInstructions
import app.morphe.patcher.patch.bytecodePatch
import com.android.tools.smali.dexlib2.iface.instruction.OneRegisterInstruction

@Suppress("unused")
val removeDeviceRestrictionsPatch = bytecodePatch(
    name = "Remove device restrictions",
    description = "Removes restrictions from using the app on any device. Requires mounting patched app over original.",
) {
    compatibleWith(AppCompatibilities.GOOGLE_RECORDER)

    execute {
        val method = ApplicationOnCreateFingerprint.method
        val featureStringIndex = ApplicationOnCreateFingerprint.instructionMatches.first().index

        method.removeInstructions(featureStringIndex - 2, 5)

        val featureAvailableRegister = method.getInstruction<OneRegisterInstruction>(featureStringIndex).registerA
        method.addInstruction(featureStringIndex, "const/4 v$featureAvailableRegister, 0x1")
    }
}

