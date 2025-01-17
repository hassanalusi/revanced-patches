package app.revanced.patches.youtube.interaction.seekbar.signatures

import app.revanced.patcher.annotation.Name
import app.revanced.patcher.annotation.Version
import app.revanced.patcher.extensions.or
import app.revanced.patcher.signature.implementation.method.MethodSignature
import app.revanced.patcher.signature.implementation.method.annotation.FuzzyPatternScanMethod
import app.revanced.patcher.signature.implementation.method.annotation.MatchingMethod
import app.revanced.patches.youtube.interaction.seekbar.annotation.SeekbarTappingCompatibility
import org.jf.dexlib2.AccessFlags
import org.jf.dexlib2.Opcode

@Name("enable-seekbar-tapping-signature")
@MatchingMethod("Lfbl;", "onTouchEvent")
@FuzzyPatternScanMethod(2) // FIXME: Test this threshold and find the best value.
@SeekbarTappingCompatibility
@Version("0.0.1")
object SeekbarTappingSignature : MethodSignature(
    "Z", AccessFlags.PUBLIC or AccessFlags.FINAL, listOf("L"), listOf(
        Opcode.INVOKE_VIRTUAL,
        Opcode.MOVE_RESULT_WIDE,
        Opcode.IGET,
        Opcode.IGET_OBJECT,
        Opcode.IGET,
        Opcode.DIV_INT_2ADDR,
        Opcode.ADD_INT,
        Opcode.SUB_INT_2ADDR,
        Opcode.INT_TO_FLOAT,
        Opcode.CMPG_FLOAT,
        Opcode.IF_GTZ,
        Opcode.INT_TO_FLOAT,
        Opcode.CMPG_FLOAT,
        Opcode.IF_GTZ,
        Opcode.CONST_4,
        Opcode.INVOKE_INTERFACE,
        Opcode.NEW_INSTANCE,
        Opcode.INVOKE_DIRECT,
        Opcode.IPUT_OBJECT,
        Opcode.INVOKE_VIRTUAL
    )
)