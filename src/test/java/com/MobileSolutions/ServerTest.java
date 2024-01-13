package com.MobileSolutions;

import org.testng.annotations.Test;
import java.io.File;
import java.net.MalformedURLException;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ServerTest {

    static AppiumDriverLocalService server;
    public static void ServerStart() throws MalformedURLException {
        String nodePath = "/home/milind/.nvm/versions/node/v20.10.0/bin/node";
        String appiumJSPath = "/home/milind/.nvm/versions/node/v20.10.0/lib/node_modules/appium/build/lib/main.js";
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withAppiumJS(new File(appiumJSPath))
                .usingDriverExecutable(new File(nodePath))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File("Appiumlog.txt"))
                .withIPAddress("127.0.0.1");
        server = AppiumDriverLocalService.buildService(builder);
        server.start();
        System.out.println("Appium Server Started");
        System.out.println("Appium Server URL: " + server.getUrl());
        server.stop();
        System.out.println("Appium Server Stoped");

    }

    public static void main(String[] args) throws MalformedURLException {
        ServerStart();
    }
}