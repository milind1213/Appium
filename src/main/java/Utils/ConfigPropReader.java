package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropReader {
	private Properties configProp;
	private FileInputStream fis;
	
	public Properties prop() {

		configProp = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/ConfigDirectory/Config.properties");
			configProp.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return configProp;
	}
	
	public Properties aap() {

		configProp = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/ConfigDirectory/Application.properties");
			configProp.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return configProp;
	}
	
}
