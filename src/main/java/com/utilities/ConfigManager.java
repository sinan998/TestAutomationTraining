package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static Properties properties;

    static {
        properties=new Properties();
        try{
            InputStream input= ConfigManager.class.getClassLoader().getResourceAsStream("configuration.properties");

            if(input== null){
                throw new RuntimeException("configuration.properties dosyası bulunamadı! Lütfen src/main/resources altına koyduğundan emin ol.");
            }

            properties.load(input);
            input.close();
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException( "Config dosyası yüklenirken hata oluştu");
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
