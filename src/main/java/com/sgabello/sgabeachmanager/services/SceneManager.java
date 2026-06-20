package com.sgabello.sgabeachmanager.services;

import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class SceneManager {

    public static void openScene(String fxmlPath, String title, double width, double height, boolean resizable) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlPath), LanguageManager.getBundle());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setMinWidth(width);
            stage.setMinHeight(height);
            stage.setResizable(resizable);
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openSceneMaximized(String fxmlPath, String title, boolean resizable) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlPath), LanguageManager.getBundle());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setMaximized(true);
            stage.setResizable(resizable);
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeScene(Node node) {
        ((Stage) node.getScene().getWindow()).close();
    }
}
