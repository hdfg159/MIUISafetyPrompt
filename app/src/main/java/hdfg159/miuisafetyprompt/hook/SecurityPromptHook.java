package hdfg159.miuisafetyprompt.hook;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import hdfg159.miuisafetyprompt.entity.HookClassInformation;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

/**
 * Project:miuisafetyprompt
 * Package:hdfg159.miuisafetyprompt.hook
 * Created by hdfg159 on 2016/11/28 20:37.
 */
public class SecurityPromptHook implements IXposedHookLoadPackage {
    private static final String MIUI_SECURITY_CENTER_PACKAGENAME = "com.miui.securitycenter";

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (isEqualsSecurityCenterPackageName(loadPackageParam)) {
            HookClassInformation hookClassInformation = getHookClassInformation();
            findAndHookMethod(hookClassInformation.getClassName(), loadPackageParam.classLoader, hookClassInformation.getMethodName(), new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                    return null;
                }
            });
        }
    }

    private HookClassInformation getHookClassInformation() {
        return SelectVersion.setEntityByVersion(getVersionName(getSystemContext()));
    }

    private Context getSystemContext() {
        Object activityThread = XposedHelpers.callStaticMethod(XposedHelpers.findClass("android.app.ActivityThread", null), "currentActivityThread");
        return (Context) XposedHelpers.callMethod(activityThread, "getSystemContext");
    }

    private String getVersionName(Context context) {
        PackageInfo packInfo = null;
        try {
            packInfo = context.getPackageManager().getPackageInfo(MIUI_SECURITY_CENTER_PACKAGENAME, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String versionName = packInfo.versionName;
        XposedBridge.log("MIUISecurityCenterVersionName:" + versionName);
        return versionName;
    }

    private boolean isEqualsSecurityCenterPackageName(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        return loadPackageParam.packageName.equals(MIUI_SECURITY_CENTER_PACKAGENAME);
    }
}
