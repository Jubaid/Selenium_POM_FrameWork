package com.spree.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigManager {

	private static ConfigManager instance = null;

    private String environment = "QA";
    private Properties properties = new Properties();
    private String fileToRead = null;

    private ConfigManager(){
        String tmp = System.getenv("ENV");
        if(tmp != null && tmp.length() > 0){
            environment = tmp.toUpperCase();
        }
        else if(environment.contentEquals("DEV")){
            fileToRead = System.getProperty("user.dir") + "/src/test/resources/config/DEV.Config.properties";
        }
        System.out.println("Environment to load: " + environment);
        System.out.println("Config to load: " + fileToRead);
        loadConfig();
    }

	private void loadConfig() {
		// TODO Auto-generated method stub
		InputStream input = null;
        try {
            input = new FileInputStream(fileToRead);
            properties.load(input);
        } catch (IOException io) {
            io.printStackTrace();
        }
	}
}
