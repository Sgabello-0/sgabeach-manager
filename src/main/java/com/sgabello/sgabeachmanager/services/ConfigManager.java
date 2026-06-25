package com.sgabello.sgabeachmanager.services;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class ConfigManager {
    private static final String CONFIG_FILE = "config.properties";
    private static Properties props = new Properties();

    public static void initialize(){
        if (!Objects.equals(props.getProperty("selected_language"), "it") || !Objects.equals(props.getProperty("selected_language"), "en")){
            props.setProperty("selected_language", "it");
        }
        try {
            props.store(new FileOutputStream(CONFIG_FILE), null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void load() {
        File file = new File(CONFIG_FILE);
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            props.load(new FileInputStream(CONFIG_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

    public static void set(String key, String value) {
        props.setProperty(key, value);
        try {
            props.store(new FileOutputStream(CONFIG_FILE), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
