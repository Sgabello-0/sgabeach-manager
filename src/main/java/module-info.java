module com.sgabello.sgabeachmanage {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sgabello.sgabeachmanage to javafx.fxml;
    exports com.sgabello.sgabeachmanage;
}