module com.example.scrat1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scrat1 to javafx.fxml;
    exports com.example.scrat1;
}