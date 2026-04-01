/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/377d4e15016296b45d809697f7f69bce74badd3a/patches/src/main/kotlin/app/revanced/patches/tiktok/misc/extension/ExtensionPatch.kt
 * https://github.com/ReVanced/revanced-patches/blob/377d4e15016296b45d809697f7f69bce74badd3a/patches/src/main/kotlin/app/revanced/patches/tiktok/misc/extension/Hooks.kt
 */

package app.morphe.patches.tiktok.misc.extension

import app.morphe.patcher.Fingerprint
import app.morphe.patches.shared.misc.extension.ExtensionHook
import app.morphe.patches.shared.misc.extension.sharedExtensionPatch

private const val MAIN_ACTIVITY_CLASS = "Lcom/ss/android/ugc/aweme/main/MainActivity;"
private const val JATO_INIT_TASK_CLASS = "Lcom/ss/android/ugc/aweme/legoImp/task/JatoInitTask;"
private const val STORE_REGION_INIT_TASK_CLASS = "Lcom/ss/android/ugc/aweme/legoImp/task/StoreRegionInitTask;"

internal object MainActivityOnCreateFingerprint : Fingerprint(
    definingClass = MAIN_ACTIVITY_CLASS,
    name = "onCreate",
    returnType = "V",
    parameters = listOf("Landroid/os/Bundle;"),
)

internal object JatoInitTaskRunFingerprint : Fingerprint(
    definingClass = JATO_INIT_TASK_CLASS,
    name = "run",
    returnType = "V",
    parameters = listOf("Landroid/content/Context;"),
)

internal object StoreRegionInitTaskRunFingerprint : Fingerprint(
    definingClass = STORE_REGION_INIT_TASK_CLASS,
    name = "run",
    returnType = "V",
    parameters = listOf("Landroid/content/Context;"),
)

private val initHook = ExtensionHook(
    fingerprint = MainActivityOnCreateFingerprint,
)

private val jatoInitHook = ExtensionHook(
    fingerprint = JatoInitTaskRunFingerprint,
    contextRegisterResolver = { "p1" },
)

private val storeRegionInitHook = ExtensionHook(
    fingerprint = StoreRegionInitTaskRunFingerprint,
    contextRegisterResolver = { "p1" },
)

val sharedExtensionPatch = sharedExtensionPatch(
    extensionName = "tiktok",
    isYouTubeOrYouTubeMusic = false,
    initHook,
    jatoInitHook,
    storeRegionInitHook,
)

