package com.sgabello.sgabeachmanager.controllers;

import com.sgabello.sgabeachmanager.modules.Client;
import com.sgabello.sgabeachmanager.services.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class ClientsController {

    @FXML private TableView<Client> clientTable;

    public void initialize(){
        clientTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
    }

    @FXML private void onAddClientClick(){
        SceneManager.openScene("/com/sgabello/sgabeachmanager/mainviewpages/add-client-view.fxml", "Add Client", 500, 500, false);
    }

}
