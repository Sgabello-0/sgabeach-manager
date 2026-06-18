package com.sgabello.sgabeachmanager;

import com.sgabello.sgabeachmanager.databasemanagers.AuthManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AuthManager.connetti();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setMinHeight(400);
        stage.setMinWidth(400);
        stage.setResizable(false);
        stage.setTitle("SgaBeach Manager");
        stage.setScene(scene);
        stage.show();
    }
}
