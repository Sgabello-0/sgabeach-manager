package com.sgabello.sgabeachmanager;

import com.sgabello.sgabeachmanager.services.ConfigManager;
import com.sgabello.sgabeachmanager.services.LanguageManager;
import com.sgabello.sgabeachmanager.services.SceneManager;
import com.sgabello.sgabeachmanager.services.databasemanagers.AuthManager;
import com.sgabello.sgabeachmanager.services.databasemanagers.DatabaseManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AuthManager.connect();
        AuthManager.createUserTableIfNotExist();
        ConfigManager.load();
        ConfigManager.initialize();
        DatabaseManager.connect();
        DatabaseManager.createTablesIfNotExist();
        LanguageManager.loadFromConfig();
        SceneManager.openScene("/com/sgabello/sgabeachmanager/login-view.fxml", "SgaBeach Manager", 450, 450, false);
    }
}
