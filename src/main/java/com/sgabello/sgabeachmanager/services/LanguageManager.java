package com.sgabello.sgabeachmanager.services;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {

    public String getCodeByString(String language){
        if (language.equals("English")){
            return "en";
        } else if (language.equals("Italiano")){
            return "it";
        } else {
            return "it";
        }
    }

    public static String getStringByCode(String code){
        if (code.equals("en")){
            return "English";
        } else if (code.equals("it")) {
            return "Italiano";
        } else {
            return "Italiano";
        }
    }

    public static Locale getLanguageFromString(String language){
        if (language.equals("en") || language.equals("English")){
            return Locale.ENGLISH;
        } else if (language.equals("it") || language.equals("Italiano")) {
            return Locale.ITALIAN;
        } else {
            return Locale.ITALIAN;
        }
    }

    private static Locale locale = Locale.ITALIAN;
    private static ResourceBundle bundle = ResourceBundle.getBundle(
            "com.sgabello.sgabeachmanager.i18n.messages", locale);

    public static void loadFromConfig() {
        String language = ConfigManager.get("selected_language", "it");
        locale = getLanguageFromString(language);
        bundle = ResourceBundle.getBundle(
                "com.sgabello.sgabeachmanager.i18n.messages", locale);
    }

    public static void setLanguage(String language){
        locale = getLanguageFromString(language);
        bundle = ResourceBundle.getBundle(
                "com.sgabello.sgabeachmanager.i18n.messages", locale);
        ConfigManager.set("selected_language", getLanguageCode());
    }

    public static String get(String key){ return bundle.getString(key); }
    public static ResourceBundle getBundle(){ return bundle; }

    public static String getLanguageCode(){return ConfigManager.get("selected_language", "it");}

}

