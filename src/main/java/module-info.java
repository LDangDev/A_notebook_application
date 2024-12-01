module org.example.a_notebook_application {
    requires javafx.controls;
    requires javafx.fxml;

    opens controller to javafx.fxml;
    exports view;
}