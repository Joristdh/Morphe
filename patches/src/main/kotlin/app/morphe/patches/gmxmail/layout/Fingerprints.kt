package app.morphe.patches.gmxmail.layout

import app.morphe.patcher.Fingerprint

internal object IsUpsellingPossibleFingerprint : Fingerprint(
    custom = { method, classDef ->
        method.name == "isUpsellingPossible" && classDef.endsWith("/PayMailManager;")
    },
)

