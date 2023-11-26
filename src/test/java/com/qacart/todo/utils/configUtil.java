package com.qacart.todo.utils;

import java.util.Properties;

public class configUtil {
    private static Properties property;
    private static configUtil configureUtils;
    private configUtil(){
        String env = System.getProperty("env" , "production");
        switch  (env){
            case"production":
                property= propertiesUtil.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
                break;
            case"LOCAL":
                property= propertiesUtil.loadProperties("src/test/java/com/qacart/todo/config/local.properties");
                break;
            default:
                throw new RuntimeException("Environment not supported");
        }

    }
    public static configUtil getInstance (){
        if (configureUtils == null){
            configureUtils = new configUtil();
        }
        return configureUtils;
    }
    public  String getBaseUrl (){
       String prop =  property.getProperty("baseUrl");
       if (prop!=null){
           return prop;
       }
        throw new RuntimeException("Could not find the base url");

    }
    public  String getُEmail (){
        String prop =  property.getProperty("email");
        if (prop!=null){
            return prop;
        }
        throw new RuntimeException("Could not find the email");

    }
    public  String getُPassword (){
        String prop =  property.getProperty("password");
        if (prop!=null){
            return prop;
        }
        throw new RuntimeException("Could not find the paswword");

    }
}
