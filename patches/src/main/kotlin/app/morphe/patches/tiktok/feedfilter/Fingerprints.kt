/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/377d4e15016296b45d809697f7f69bce74badd3a/patches/src/main/kotlin/app/revanced/patches/tiktok/feedfilter/Fingerprints.kt
 */

package app.morphe.patches.tiktok.feedfilter

import app.morphe.patcher.Fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

internal object FeedItemListGetItemsFingerprint : Fingerprint(
    accessFlags = listOf(AccessFlags.PUBLIC),
    returnType = "Ljava/util/List;",
    custom = { method, classDef ->
        classDef.endsWith("/FeedItemList;") &&
            method.name == "getItems" &&
            method.parameterTypes.isEmpty()
    },
)

internal object FollowFeedFingerprint : Fingerprint(
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    returnType = "Lcom/ss/android/ugc/aweme/follow/presenter/FollowFeedList;",
    custom = { method, _ ->
        method.parameterTypes.size == 2
    },
)

