package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

import java.io.IOException;

public class questionModel {
    @FXML
    private Button okayButton;

    @FXML
    public void doNothing() throws IOException {
        Stage stage = (Stage)okayButton.getScene().getWindow();
        stage.close();
    }
}
