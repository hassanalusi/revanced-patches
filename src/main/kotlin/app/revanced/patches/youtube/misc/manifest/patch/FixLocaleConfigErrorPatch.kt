package app.revanced.patches.youtube.misc.manifest.patch

import app.revanced.patcher.annotation.Description
import app.revanced.patcher.annotation.Name
import app.revanced.patcher.annotation.Version
import app.revanced.patcher.data.implementation.ResourceData
import app.revanced.patcher.patch.implementation.ResourcePatch
import app.revanced.patcher.patch.implementation.misc.PatchResult
import app.revanced.patcher.patch.implementation.misc.PatchResultSuccess
import app.revanced.patches.youtube.misc.manifest.annotations.FixLocaleConfigErrorCompatibility
import org.w3c.dom.Element

@Name("locale-config-fix")
@Description("Fix an error when building the resources by patching the manifest file.")
@FixLocaleConfigErrorCompatibility
@Version("0.0.1")
class FixLocaleConfigErrorPatch : ResourcePatch() {
    override fun execute(data: ResourceData): PatchResult {
        // create an xml editor instance
        data.getXmlEditor("AndroidManifest.xml").use {
            // edit the application nodes attribute...
            val applicationNode = it
                .file
                .getElementsByTagName("application")
                .item(0) as Element


            // by replacing the attributes name
            val attribute = "android:localeConfig"
            applicationNode.setAttribute("localeConfig", applicationNode.getAttribute(attribute))
            applicationNode.removeAttribute("android:localeConfig")

        }

        return PatchResultSuccess()
    }
}
