package app.morphe.patches.gmxmail.freephone

import app.morphe.patcher.Fingerprint

internal object IsEuiccEnabledFingerprint : Fingerprint(
    custom = { method, _ -> method.name == "isEuiccEnabled" },
)

