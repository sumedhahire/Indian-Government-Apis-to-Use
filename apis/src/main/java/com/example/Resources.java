package com.example;

import java.io.FileInputStream;
import java.util.Properties;

public class Resources {
    

    public static String getApiKey() {
        Properties props=new Properties();
        try{
            props.load(new FileInputStream("apis\\src\\main\\resources\\config.properties"));
            return props.getProperty("api.key");
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getApiKey());
    }
}
