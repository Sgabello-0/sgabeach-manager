package com.sgabello.sgabeachmanager.controllers;

import com.sgabello.sgabeachmanager.services.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddClientsController {

    @FXML private TextField firstNameField;

    @FXML private void onAddClick(){
        SceneManager.closeScene(firstNameField);
    }
}
