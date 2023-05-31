package com.sms.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {

	/**
	 * This method is used to return the value of a key which is in property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromPropertyFile(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream(IpathConstant.propertyFilepath);
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
		
	}
}
