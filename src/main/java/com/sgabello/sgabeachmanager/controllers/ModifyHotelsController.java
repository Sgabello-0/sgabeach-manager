package com.sgabello.sgabeachmanager.controllers;

import com.sgabello.sgabeachmanager.services.SceneManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyHotelsController implements Initializable {

    @FXML private TextField hotelNameField;
    @FXML private TableView<String> hotelsTable;
    @FXML private TableColumn<String, String> colHotelName;

    private final ObservableList<String> hotelList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hotelsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        colHotelName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
        hotelsTable.setItems(hotelList);
        loadHotels();
    }

    @FXML
    private void onAddClick() {
        String name = hotelNameField.getText().trim();
        if (name.isBlank()) return;
        hotelList.add(name);
        hotelNameField.clear();
    }

    @FXML
    private void onImportClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Import Hotel List");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text files", "*.txt")
        );

        File file = fileChooser.showOpenDialog(hotelsTable.getScene().getWindow());
        if (file == null) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) hotelList.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onOKClick() {
        saveHotels();
        SceneManager.closeScene(hotelNameField);
    }

    private void loadHotels() {
        File file = getHotelsFile();
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) hotelList.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveHotels() {
        File file = getHotelsFile();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String hotel : hotelList) {
                writer.write(hotel);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getHotelsFile() {
        String userHome = System.getProperty("user.home");
        return new File(userHome + "/sgabeach-manager/hotels.txt");
    }
}