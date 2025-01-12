package Reader;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

	final static String path = System.getProperty("user.dir") + "//src//main//resources//config.properties";

	public static String getProperty(String key) {
		Properties prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
		return prop.getProperty(key);
	}

}
