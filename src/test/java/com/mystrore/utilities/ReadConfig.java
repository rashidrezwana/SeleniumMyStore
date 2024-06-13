package com.mystrore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;



public class ReadConfig {

	Properties properties;

	String path = "D:\\QA Tools\\SeleniumDemo\\mystore\\Configurations\\config.properties";

	//constructor
	public ReadConfig() {
		try {
			properties = new Properties();

			FileInputStream  fis = new FileInputStream(path);
			properties.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public String getUrl()
	{
		String value = properties.getProperty("baseUrl");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}

	public String getBrowser()
	{
		String value = properties.getProperty("browser");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}
	public String getOS()
	{
		String value = properties.getProperty("os");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("os is not specified in config file.");

	}
	public String getMachine()
	{
		String value = properties.getProperty("machine");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("machine is not specified in config file.");

	}
	public String getUserName()
	{
		String value = properties.getProperty("userName");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("userName is not specified in config file.");

	}
	public String getEmail()
	{
		String email = properties.getProperty("email");
		if(email!=null)
			return email;
		else
			throw new RuntimeException("email not specified in config file.");
		
	}

	public String getPassword()
	{
		String password = properties.getProperty("password");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not specified in config file.");
		
	}

}
