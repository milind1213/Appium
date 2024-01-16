package CommonUtility;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

import Utils.ConfigPropReader;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {
	public AppiumDriverLocalService server;
	public ConfigPropReader config = new ConfigPropReader();

	public void startServer() {
		if (!isAppiumServerRunning(Integer.parseInt(config.prop().getProperty("portNum")))) {
			server = new AppiumServiceBuilder().usingDriverExecutable(new File(config.prop().getProperty("nodePath")))
					.withAppiumJS(new File(config.prop().getProperty("mainJs")))
					.withIPAddress(config.prop().getProperty("ip"))
					.usingPort(Integer.parseInt(config.prop().getProperty("portNum"))).build();
			server.start();
			System.out.println("***** Appium server started ******");
		} else {
			System.out.println("***** Appium server is already running ******");
		}
	}

	public void stopServer() {
		if (server != null && server.isRunning()) {
			server.stop();
		}
		System.out.println("***** Appium server Stoped ******");
	}

	private boolean isAppiumServerRunning(int port) {
		try (Socket socket = new Socket("127.0.0.1", port)) {
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}