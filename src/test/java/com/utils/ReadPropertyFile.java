package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import com.constants.Constants;

public class ReadPropertyFile {
	
	private static final Properties prop = new Properties();

	private ReadPropertyFile() {

	}
	//	static block
	static {
		try {
			FileInputStream  fis= new FileInputStream(Constants.getConfigFilePath());
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String  getValue(String key) throws Exception {
		if (Objects.isNull(prop.getProperty(key)) ||  Objects.isNull(key)) {
			throw new Exception("Property name "+ key + "is not found. Please check the config file ");
		}
		return  prop.getProperty(key);
	}

}
