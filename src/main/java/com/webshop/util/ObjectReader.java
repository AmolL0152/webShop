package com.webshop.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ObjectReader {
	private Properties properties;
//	private final String propertyFilePath= "../WebSHop/properties/config.properties";
 
	/* Constructor user to initialise property file
	 * @path - path of properties file
	 * @author - Amol
	 * 
	 */
		
	public ObjectReader(String propertyFilePath){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}

	/* Methos used to retrieve property files values
	 * @author - Amol
	 * 
	 */	
	public String getProperties(String key) {
		// TODO Auto-generated method stub
		String value = properties.getProperty(key);
		if(value != null) 
			return value;
		else throw 
			new RuntimeException(key + "Value specified in the Configuration.properties file.");
	}
}
