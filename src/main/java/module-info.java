module com.gardhagen.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gardhagen to javafx.fxml;
    exports com.gardhagen;
}