package com.sgabello.sgabeachmanager.services;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {

    private static Locale locale = Locale.ENGLISH;
    private static ResourceBundle bundle = ResourceBundle.getBundle(
            "com.sgabello.sgabeachmanager.i18n.messages", locale);

    public static void setLanguage(Locale newLocale){
        locale = newLocale;
        bundle = ResourceBundle.getBundle(
                "com.sgabello.sgabeachmanager.i18n.messages", locale);
    }

    public static String get(String key){
        return bundle.getString(key);
    }

    public static Locale getLocale() {return locale;}
}
