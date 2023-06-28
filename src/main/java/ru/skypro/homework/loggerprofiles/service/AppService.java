package ru.skypro.homework.loggerprofiles.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.loggerprofiles.pojo.AppInfo;

@Service
public class AppService {
    public AppInfo getAppInfo(String appEnv) {
        String appName = "logger-info";
        String appEnvString = appEnv;
        String os = System.getProperty("os.name");
        return new AppInfo(appName, appEnvString, os);
    }
}
