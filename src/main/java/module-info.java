module com.sgabello.sgabeachmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sgabello.sgabeachmanager to javafx.fxml;
    exports com.sgabello.sgabeachmanager;
}