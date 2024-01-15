package CommonUtils;

import java.io.File;
import Utils.ConfigPropReader;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {

	public AppiumDriverLocalService server;
	public ConfigPropReader config = new ConfigPropReader();

	public void startServer() {
		server = new AppiumServiceBuilder().usingDriverExecutable(new File(config.prop().getProperty("nodePath")))
				.withAppiumJS(new File(config.prop().getProperty("mainJs")))
				.withIPAddress(config.prop().getProperty("ip"))
				.usingPort(Integer.parseInt(config.prop().getProperty("portNum"))).build();
		server.start();
		System.out.println("***** Appium server started ******");
	}
 
	public void stopServer() {
		if (server != null && server.isRunning()) {
			server.stop();
		}
		System.out.println("***** Appium server Stoped ******");
	}

}
