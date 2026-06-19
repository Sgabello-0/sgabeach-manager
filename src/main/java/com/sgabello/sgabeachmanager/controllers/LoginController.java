package com.sgabello.sgabeachmanager.controllers;

import com.sgabello.sgabeachmanager.modules.User;
import com.sgabello.sgabeachmanager.services.Alerts;
import com.sgabello.sgabeachmanager.services.SceneManager;
import com.sgabello.sgabeachmanager.services.databasemanagers.AuthManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField userField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;

    private boolean userExist = AuthManager.userExist();

    private void onLoginClick(){
        String username = userField.getText();
        String password = passwordField.getText();
        if (username != null && password != null){
            User user = new User(username, password);
            if(AuthManager.loginUser(user)){
                SceneManager.openSceneMaximized("/com/sgabello/sgabeachmanager/main-view.fxml", "SgaBeach Manager", false);
                SceneManager.closeScene(userField);
            } else {
                Alerts.alertErrore("The user doesn't exist.");
            }
        } else {
            Alerts.alertErrore("Username and password can't be blank.");
        }

    }

    private void onRegisterClick(){
        String username = userField.getText();
        String password = passwordField.getText();
        if (username != null && password != null){
            User user = new User(username, password);
            AuthManager.createUser(user);
        }

        SceneManager.openScene("com/sgabello/sgabeachmanager/login-view.fxml", "SgaBeach Manager", 400, 400, false);
        SceneManager.closeScene(userField);
    }

    public void initialize(){
        if (userExist){
            loginButton.setText("Accedi");
            loginButton.setOnAction(event -> onLoginClick());
        } else {
            loginButton.setText("Registrati");
            loginButton.setOnAction(event -> onRegisterClick());
        }
    }

}
