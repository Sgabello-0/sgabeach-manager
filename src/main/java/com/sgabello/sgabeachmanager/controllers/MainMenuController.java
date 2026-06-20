package com.sgabello.sgabeachmanager.controllers;

import com.sgabello.sgabeachmanager.services.Alerts;
import com.sgabello.sgabeachmanager.services.LanguageManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainMenuController {

    @FXML private BorderPane mainBorderPane;

    private void loadPage(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Node page = loader.load();
            mainBorderPane.setCenter(page);
        } catch (IOException e) {
            Alerts.alertErrore(LanguageManager.get("alert.context.main.newpage ") + e.getMessage());
        }
    }

}
