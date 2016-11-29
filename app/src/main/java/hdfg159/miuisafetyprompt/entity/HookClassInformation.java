package hdfg159.miuisafetyprompt.entity;

/**
 * Project:MIUISafetyPrompt
 * Package:hdfg159.miuisafetyprompt.entity
 * Created by hdfg159 on 2016/11/29 13:39.
 */
public class HookClassInformation {
    private String className;
    private String methodName;

    public HookClassInformation(String className, String methodName) {
        this.className = className;
        this.methodName = methodName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
