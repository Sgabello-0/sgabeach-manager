package com.sgabello.sgabeachmanager.controllers;

import com.sgabello.sgabeachmanager.services.Alerts;
import com.sgabello.sgabeachmanager.services.LanguageManager;
import com.sgabello.sgabeachmanager.services.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainMenuController {

    @FXML private BorderPane mainBorderPane;

    @FXML private void onSettingsClick(){
        SceneManager.loadPage("/com/sgabello/sgabeachmanager/mainviewpages/settings-view.fxml", mainBorderPane);
    }

}
