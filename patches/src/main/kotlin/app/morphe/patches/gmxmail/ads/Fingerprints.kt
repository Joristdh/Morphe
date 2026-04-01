package app.morphe.patches.gmxmail.ads

import app.morphe.patcher.Fingerprint

internal object GetAdvertisementStatusFingerprint : Fingerprint(
    custom = { method, classDef ->
        method.name == "getAdvertisementStatus" && classDef.endsWith("/PayMailManager;")
    },
)

