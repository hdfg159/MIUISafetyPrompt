package hdfg159.miuisafetyprompt.hook;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
/**
 * Project:miuisafetyprompt
 * Package:hdfg159.miuisafetyprompt.hook
 * Created by hdfg159 on 2016/11/28 20:37.
 */
public class SecurityPromptHook implements IXposedHookLoadPackage {
    private static final String MIUI_SECURITY_CENTER_PACKAGENAME = "com.miui.securitycenter";
    private static final String STATUSBAR_SECURITY_PROMPY_CLASSNAME = "com.miui.securitycenter.service.g";

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (isEqualsSecurityCenterPackageName(loadPackageParam)) {
            findAndHookMethod(STATUSBAR_SECURITY_PROMPY_CLASSNAME, loadPackageParam.classLoader, "fN", new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                    return null;
                }
            });
        }
    }

    private boolean isEqualsSecurityCenterPackageName(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        return loadPackageParam.packageName.equals(MIUI_SECURITY_CENTER_PACKAGENAME);
    }
}
