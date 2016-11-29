package hdfg159.miuisafetyprompt.hook;

import hdfg159.miuisafetyprompt.entity.HookClassInformation;

/**
 * Project:MIUISafetyPrompt
 * Package:hdfg159.miuisafetyprompt.hook
 * Created by hdfg159 on 2016/11/29 13:43.
 */
public class SelectVersion {
    private static final String className = "com.miui.securitycenter.service.g";

    public static HookClassInformation setEntityByVersion(String versionName) {
        HookClassInformation hookClassInformation;
        switch (versionName) {
            case "2.0.0":
                hookClassInformation = new HookClassInformation(className, "fN");
                break;
            case "2.0.1":
                hookClassInformation = new HookClassInformation(className, "gA");
                break;
            default:
                hookClassInformation = new HookClassInformation(className, "gA");
                break;
        }
        return hookClassInformation;
    }
}
