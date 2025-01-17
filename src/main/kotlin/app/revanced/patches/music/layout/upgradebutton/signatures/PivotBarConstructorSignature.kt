package app.revanced.patches.music.layout.upgradebutton.signatures

import app.revanced.patcher.annotation.Name
import app.revanced.patcher.annotation.Version
import app.revanced.patcher.extensions.or
import app.revanced.patcher.signature.implementation.method.MethodSignature
import app.revanced.patcher.signature.implementation.method.annotation.FuzzyPatternScanMethod
import app.revanced.patcher.signature.implementation.method.annotation.MatchingMethod
import app.revanced.patches.music.layout.upgradebutton.annotations.RemoveUpgradeButtonCompatibility
import org.jf.dexlib2.AccessFlags
import org.jf.dexlib2.Opcode

@Name("pivot-bar-constructor")
@MatchingMethod(
    "Lhfu;", "<init2>"
)
@FuzzyPatternScanMethod(2) // FIXME: Test this threshold and find the best value.
@RemoveUpgradeButtonCompatibility
@Version("0.0.1")
object PivotBarConstructorSignature : MethodSignature(
    "V",
    AccessFlags.PUBLIC or AccessFlags.CONSTRUCTOR,
    listOf("L", "Z"),
    listOf(
        Opcode.INVOKE_DIRECT,
        Opcode.CONST_4,
        Opcode.IPUT_OBJECT,
        Opcode.IPUT_OBJECT,
        Opcode.IPUT_BOOLEAN,
        Opcode.IGET_OBJECT,
        Opcode.IF_NEZ,
        Opcode.GOTO,
        Opcode.NEW_INSTANCE,
        Opcode.INVOKE_DIRECT,
        Opcode.IGET_OBJECT,
        Opcode.INVOKE_INTERFACE,
        Opcode.MOVE_RESULT_OBJECT,
        Opcode.INVOKE_INTERFACE,
        Opcode.MOVE_RESULT,
        Opcode.IF_EQZ,
        Opcode.INVOKE_INTERFACE,
        Opcode.MOVE_RESULT_OBJECT,
        Opcode.CHECK_CAST,
        Opcode.IGET,
        Opcode.CONST,
        Opcode.IF_NE,
        Opcode.IGET_OBJECT,
        Opcode.CHECK_CAST,
        Opcode.GOTO,
        Opcode.SGET_OBJECT,
        Opcode.IGET_OBJECT,
        Opcode.INVOKE_INTERFACE,
        Opcode.MOVE_RESULT_OBJECT,
        Opcode.INVOKE_INTERFACE,
        Opcode.MOVE_RESULT,
        Opcode.IF_EQZ,
        Opcode.INVOKE_INTERFACE,
        Opcode.MOVE_RESULT_OBJECT,
        Opcode.CHECK_CAST,
        Opcode.IGET,
        Opcode.CONST,
        Opcode.IF_NE,
        Opcode.IGET_OBJECT,
        Opcode.CHECK_CAST,
        Opcode.INVOKE_INTERFACE,
        Opcode.GOTO,
        Opcode.NOP,
        Opcode.IPUT_OBJECT,
        Opcode.RETURN_VOID
    )
)