package app.morphe.patches.angulus.ads

import app.morphe.patches.shared.compat.AppCompatibilities
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.util.returnEarly

@Suppress("unused")
val hideAdsPatch = bytecodePatch("Hide ads") {
    compatibleWith(AppCompatibilities.ANGULUS)

    execute {
        GetDailyMeasurementCountFingerprint.method.returnEarly(0)
    }
}

