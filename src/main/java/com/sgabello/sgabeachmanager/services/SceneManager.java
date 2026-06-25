package com.sgabello.sgabeachmanager.services;

import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
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

    public static void loadPage(String fxmlPath, BorderPane borderPane) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlPath), LanguageManager.getBundle());
            Node page = loader.load();
            borderPane.setCenter(page);
        } catch (IOException e) {
            e.printStackTrace();
            Alerts.alertErrore(LanguageManager.get("alert.context.main.newpage") + e.getMessage());
        }
    }

    public static void closeScene(Node node) {
        ((Stage) node.getScene().getWindow()).close();
    }

    public static void closeAllScenes(){
        new ArrayList<>(Stage.getWindows()).forEach(window -> ((Stage) window).close());
    }

    public static void restartApp(){
        closeAllScenes();
        openScene("/com/sgabello/sgabeachmanager/login-view.fxml", "SgaBeach Manager", 400, 400, false);
    }
}
