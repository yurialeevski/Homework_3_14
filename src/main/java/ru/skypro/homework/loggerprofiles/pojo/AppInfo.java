package ru.skypro.homework.loggerprofiles.pojo;

public class AppInfo {
    private String appName;
    private String appEnv;
    private String os;

    public AppInfo() {
    }

    public AppInfo(String appName, String appEnv, String os) {
        this.appName = appName;
        this.appEnv = appEnv;
        this.os = os;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppEnv() {
        return appEnv;
    }

    public String getOs() {
        return os;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "appName='" + appName + '\'' +
                ", appEnv='" + appEnv + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
