package sample.controllers;

import sample.classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    private Button rulesButton;
    @FXML
    private Button startButton;

    @FXML
    public void initialize() {
    }

    public void beginning() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/gameWindow.fxml"));
        Stage stage = (Stage)startButton.getScene().getWindow();
        stage.setTitle("It's your time to hack");
        stage.setScene(new Scene(root, 1000, 600));
        stage.setResizable(false);
        stage.show();
    }

    public void showCredits() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/creditsWindow.fxml"));
        Stage stage = (Stage)rulesButton.getScene().getWindow();
        stage.setTitle("Developers");
        stage.setScene(new Scene(root, 1000, 600));
        stage.setResizable(false);
        stage.show();
    }

    public void showRules() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/rulesWindow.fxml"));
        Stage stage = (Stage)rulesButton.getScene().getWindow();
        stage.setTitle("Game Rules");
        stage.setScene(new Scene(root, 1000, 600));
        stage.setResizable(false);
        stage.show();
    }

    public void quit() {
        System.exit(1);
    }

}
