package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RulesController {
    @FXML
    private Button backButton;

    @FXML
    public void initialize() {
    }
    @FXML
    public void goBack() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/mainWindow.fxml"));
        Stage stage = (Stage)backButton.getScene().getWindow();
        stage.setTitle("The Game");
        stage.setScene(new Scene(root,1000,600));
        stage.setResizable(true);
        stage.show();
    }
}
