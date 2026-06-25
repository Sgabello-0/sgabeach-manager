package com.sgabello.sgabeachmanager.controllers;

import com.sgabello.sgabeachmanager.services.LanguageManager;
import com.sgabello.sgabeachmanager.services.SceneManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;

public class SettingsController {

    @FXML private ComboBox<String> comboLanguage;
    @FXML private PasswordField newPasswordField;
    @FXML private PasswordField confirmPasswordField;


    public void initialize(){
        comboLanguage.setItems(FXCollections.observableArrayList("Italiano", "English"));
        comboLanguage.setValue(LanguageManager.getStringByCode(LanguageManager.getLanguageCode()));
    }

    @FXML private void onChangeLanguageClick() {
        LanguageManager.setLanguage(comboLanguage.getValue());
        SceneManager.restartApp();
    }

    @FXML private void onChangePasswordClick() {
    }

}
