package com.sgabello.sgabeachmanager.services;

import javafx.scene.control.Alert;

public class Alerts {

    public static void alertErrore(String context){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(LanguageManager.get("alert.title.error"));
        alert.setHeaderText(null);
        alert.setContentText(context);
        alert.showAndWait();
    }
}
