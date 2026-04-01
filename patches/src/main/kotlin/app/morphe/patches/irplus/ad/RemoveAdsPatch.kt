package app.morphe.patches.irplus.ad

import app.morphe.patches.shared.compat.AppCompatibilities
import app.morphe.patcher.extensions.InstructionExtensions.addInstruction
import app.morphe.patcher.patch.bytecodePatch

@Suppress("unused")
val removeAdsPatch = bytecodePatch("Remove ads") {
    compatibleWith(AppCompatibilities.IRPLUS)

    execute {
        IrplusAdsMethodFingerprint.method.addInstruction(0, "const/4 p2, 0x0")
    }
}

