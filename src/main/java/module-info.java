module com.sgabello.sgabeachmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.sgabello.sgabeachmanager to javafx.fxml;
    exports com.sgabello.sgabeachmanager;
    exports com.sgabello.sgabeachmanager.controllers;
    opens com.sgabello.sgabeachmanager.controllers to javafx.fxml;
}