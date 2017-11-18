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

public class menuController {
    @FXML
    private Button rulesButton;
    @FXML
    private Button startButton;

    @FXML
    public void initialize() {
    }

    public void beginning() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/atmMachine.fxml"));
        Stage stage = (Stage)startButton.getScene().getWindow();
        stage.setTitle("It's your time to hack");
        stage.setScene(new Scene(root, 450, 475));
        stage.setResizable(false);
        stage.show();
    }

    public void showCredits(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/creditsWindow.fxml"));
        Stage stage = (Stage)rulesButton.getScene().getWindow();
        stage.setTitle("Developer's Credits");
        stage.setScene(new Scene(root, 450, 475));
        stage.setResizable(false);
        stage.show();
    }

    public void showRules(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/rulesWindow.fxml"));
        Stage stage = (Stage)rulesButton.getScene().getWindow();
        stage.setTitle("Game Rules");
        stage.setScene(new Scene(root, 450, 475));
        stage.setResizable(false);
        stage.show();
    }

    public void quit(ActionEvent actionEvent) {
        System.exit(1);
    }

}
