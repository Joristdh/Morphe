/*
 * Forked from:
 * https://github.com/ReVanced/revanced-patches/blob/377d4e15016296b45d809697f7f69bce74badd3a/patches/src/main/kotlin/app/revanced/patches/tiktok/interaction/speed/PlaybackSpeedPatch.kt
 */

package app.morphe.patches.tiktok.interaction.speed

import app.morphe.patches.shared.compat.AppCompatibilities
import app.morphe.patcher.extensions.InstructionExtensions.addInstruction
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.extensions.InstructionExtensions.getInstruction
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.tiktok.misc.extension.sharedExtensionPatch
import app.morphe.patches.tiktok.shared.GetEnterFromFingerprint
import app.morphe.patches.tiktok.shared.OnRenderFirstFrameFingerprint
import app.morphe.util.getReference
import app.morphe.util.indexOfFirstInstructionOrThrow
import com.android.tools.smali.dexlib2.iface.instruction.OneRegisterInstruction
import com.android.tools.smali.dexlib2.iface.reference.MethodReference

@Suppress("unused")
val playbackSpeedPatch = bytecodePatch(
    name = "Playback speed",
    description = "Enables the playback speed option for all videos and retains the speed configurations in between videos. (Disabled for TikTok 43.8.3.)",
    default = false,
) {
    dependsOn(sharedExtensionPatch)

    compatibleWith(*AppCompatibilities.tiktok4383())

    execute {
        GetSpeedFingerprint.method.apply {
            val injectIndex = indexOfFirstInstructionOrThrow { getReference<MethodReference>()?.returnType == "F" } + 2
            val register = getInstruction<OneRegisterInstruction>(injectIndex - 1).registerA

            addInstruction(
                injectIndex,
                "invoke-static { v$register }, " +
                    "Lapp/morphe/extension/tiktok/speed/PlaybackSpeedPatch;->rememberPlaybackSpeed(F)V",
            )
        }

        OnRenderFirstFrameFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x1
                invoke-virtual { p0, v0 }, ${GetEnterFromFingerprint.originalMethod}
                move-result-object v0

                invoke-virtual { p0 }, Lcom/ss/android/ugc/aweme/feed/panel/BaseListFragmentPanel;->getCurrentAweme()Lcom/ss/android/ugc/aweme/feed/model/Aweme;
                move-result-object v1
                if-eqz v1, :revanced_skip_set_speed

                invoke-static {}, Lapp/morphe/extension/tiktok/speed/PlaybackSpeedPatch;->getPlaybackSpeed()F
                move-result v2

                const/4 v3, 0x0
                invoke-static { v0, v1, v2, v3 }, LX/0MbX;->LJ(Ljava/lang/String;Lcom/ss/android/ugc/aweme/feed/model/Aweme;FLjava/lang/String;)V

                :revanced_skip_set_speed
                nop
            """,
        )

        // Deprecated upstream for 43.8.3 (patch is disabled via default=false).
    }
}

