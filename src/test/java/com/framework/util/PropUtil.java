package com.framework.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {


	/*****************************************************************************
	 * Name : getProps Description : Reads the Properties file Input Content :
	 * Instance of the properties file
	 *****************************************************************************/
	public static Properties getProps(String file) {
		Properties properties = null;
		try {

			properties = new Properties();
			// Reading the properties file
			properties.load(new FileInputStream(file));
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println(fileNotFoundException);
		} catch (IOException ioException) {
			System.err.println(ioException);
		}
		return properties;
	}


	/*****************************************************************************
	 * Name : getPropValue Description : Returns the the Property value
	 * depending on the key Input Content : Properties Object, key of the
	 * required property
	 *****************************************************************************/
	public static String getPropValue(Properties properties, String key) {
		// Returning the Property value depends on Key
		return properties.getProperty(key);
	}

	/*****************************************************************************
	 * Name : setProps Description : Set the properties Instance Input Content :
	 * Properties Object
	 *****************************************************************************/
	public static void setProps(Properties properties, String key, String value) {
		// Setting the Properties Object
		properties.setProperty(key, value);
	}

	public static void setPropValue(String key,String val) {
		String strVal = null;
		String filePath = PathUtil.CONFIG_DIR + PathUtil.CONFIG_FILE_NAME;
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			Properties properteis = new Properties();
			properteis.load(fileInputStream);
			properteis.setProperty(key, val);

		} catch (IOException ioException) {
			System.err.println(ioException);
		}
	}
	public static String getPropKeyVal(String key) throws IOException {
		String filePath=PathUtil.CONFIG_DIR+PathUtil.CONFIG_FILE_NAME;
		FileInputStream fileInputStream = new FileInputStream(filePath);
		Properties properteis = new Properties();
		properteis.load(fileInputStream);
		String Prop = properteis.getProperty(key);
		System.out.println(key);
		return Prop;
	}



}
