package ru.skypro.homework.loggerprofiles.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.loggerprofiles.pojo.AppInfo;
import ru.skypro.homework.loggerprofiles.service.AppService;
import ru.skypro.homework.loggerprofiles.service.EmployeeServiceImpl;

@RestController
public class InfoController {
    public static final Logger logger = LoggerFactory.getLogger(InfoController.class.getName());
    private final AppService appService;

    public InfoController(AppService appService) {
        this.appService = appService;
    }

    @Value("${app.env}")
    //@Value("VALUE")
    private String appEnv;
    @GetMapping("/get/appInfo")
    public AppInfo getEmployeeById() {
        logger.info("Значение свойства среды приложения app.Env: " + appEnv);
        AppInfo appInfo = appService.getAppInfo(appEnv);
        logger.info("Информация о среде приложения: " + appInfo);
        return appInfo;
    }
}
