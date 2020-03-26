package Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderUtility {
	public static String getPropertyVal(String key,String filename) {
		String val = null;
		Properties props = new Properties();
		try {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"/TestData/Properties/"+filename);
			props.load(fr);
			val = props.getProperty(key);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return val;

	}

}