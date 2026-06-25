package com.sgabello.sgabeachmanager.controllers;

import com.sgabello.sgabeachmanager.modules.User;
import com.sgabello.sgabeachmanager.services.Alerts;
import com.sgabello.sgabeachmanager.services.LanguageManager;
import com.sgabello.sgabeachmanager.services.SceneManager;
import com.sgabello.sgabeachmanager.services.databasemanagers.AuthManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;

public class SettingsController {

    @FXML private ComboBox<String> comboLanguage;
    @FXML private PasswordField oldPasswordField;
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
        String oldPassword = oldPasswordField.getText();
        if (AuthManager.checkPasswords(oldPassword)){
            String newPassword = newPasswordField.getText();
            String confirmPassword = confirmPasswordField.getText();
            if (!newPassword.isEmpty() && !confirmPassword.isEmpty()){
                if (newPassword.equals(confirmPassword)){
                    User user = new User(AuthManager.getUsername(), newPassword);
                    AuthManager.updatePassword(user);
                    Alerts.information(LanguageManager.get("alert.context.settings.account.passwordchanged"));
                } else {
                    Alerts.error(LanguageManager.get("alert.context.settings.account.notsamepassowrd"));
                }
            } else {
                Alerts.error(LanguageManager.get("alert.context.settings.account.blankpassowrd"));
            }
        } else {
            Alerts.error(LanguageManager.get("alert.context.settings.account.wrongpassword"));
        }
    }
}
