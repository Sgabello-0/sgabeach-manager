package com.sgabello.sgabeachmanager.controllers;

import com.sgabello.sgabeachmanager.modules.User;
import com.sgabello.sgabeachmanager.services.Alerts;
import com.sgabello.sgabeachmanager.services.LanguageManager;
import com.sgabello.sgabeachmanager.services.SceneManager;
import com.sgabello.sgabeachmanager.services.databasemanagers.AuthManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField userField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;

    private final boolean userExist = AuthManager.userExist();

    private void onLoginClick(){
        String username = userField.getText();
        String password = passwordField.getText();
        if (username != null && password != null){
            User user = new User(username, password);
            if(AuthManager.loginUser(user)){
                SceneManager.openSceneMaximized("/com/sgabello/sgabeachmanager/main-view.fxml", LanguageManager.get("app.title"), false);
                SceneManager.closeScene(userField);
            } else {
                Alerts.error(LanguageManager.get("alert.context.login.userdoesntexist"));
            }
        } else {
            Alerts.error(LanguageManager.get("alert.context.login.fieldsnotblank"));
        }

    }

    private void onRegisterClick(){
        String username = userField.getText();
        String password = passwordField.getText();
        if (username != null && password != null){
            User user = new User(username, password);
            AuthManager.createUser(user);
        }

        SceneManager.openScene("com/sgabello/sgabeachmanager/login-view.fxml", LanguageManager.get("app.title"), 400, 400, false);
        SceneManager.closeScene(userField);
    }

    public void initialize(){
        if (userExist){
            loginButton.setText(LanguageManager.get("login.button.login"));
            loginButton.setOnAction(event -> onLoginClick());
        } else {
            loginButton.setText(LanguageManager.get("login.button.register"));
            loginButton.setOnAction(event -> onRegisterClick());
        }
    }

}
