package ru.skypro.homework.loggerprofiles.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.loggerprofiles.pojo.AppInfo;
import ru.skypro.homework.loggerprofiles.service.AppService;

@RestController
public class InfoController {
    private final AppService appService;

    public InfoController(AppService appService) {
        this.appService = appService;
    }

    @Value("${app.env}")
    //@Value("VALUE")
    private String appEnv;
    @GetMapping("/get/appInfo")
    public AppInfo getEmployeeById() {
        AppInfo appInfo = appService.getAppInfo(appEnv);
        System.out.println(appInfo);
        return appInfo;
    }
}
