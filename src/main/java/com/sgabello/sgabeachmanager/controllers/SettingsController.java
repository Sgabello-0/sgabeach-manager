package com.sgabello.sgabeachmanager.controllers;

import com.sgabello.sgabeachmanager.services.LanguageManager;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;

public class SettingsController {

    @FXML private ComboBox<String> comboLanguage;
    @FXML private PasswordField newPasswordField;
    @FXML private PasswordField confirmPasswordField;

    private void initialize(){
        comboLanguage.setItems(FXCollections.observableArrayList("Italiano", "English"));
        comboLanguage.setValue(LanguageManager.getLanguage().equals("en") ? "English" : "Italiano");
    }

    @FXML private void onSaveLanguageClick() {
    }

    @FXML private void onChangePasswordClick() {
    }

}
