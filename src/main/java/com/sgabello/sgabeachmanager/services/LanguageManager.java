package com.sgabello.sgabeachmanager.services;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {

    private static Locale locale = Locale.ITALIAN;
    private static ResourceBundle bundle = ResourceBundle.getBundle(
            "com.sgabello.sgabeachmanager.i18n.messages", locale);

    public static void loadFromConfig() {
        String lingua = ConfigManager.get("selected_language", "it");
        locale = lingua.equals("en") ? Locale.ENGLISH : Locale.ITALIAN;
        bundle = ResourceBundle.getBundle(
                "com.sgabello.sgabeachmanager.i18n.messages", locale);
    }

    public static void setLanguage(Locale newLocale){
        locale = newLocale;
        bundle = ResourceBundle.getBundle(
                "com.sgabello.sgabeachmanager.i18n.messages", locale);
        ConfigManager.set("selected_language", newLocale == Locale.ENGLISH ? "en" : "it");
    }

    public static String get(String key){ return bundle.getString(key); }
    public static ResourceBundle getBundle(){ return bundle; }

    public static String getLanguage(){return ConfigManager.get("selected_language", "it");}

}

