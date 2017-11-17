package sample.controllers;

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
    private Button startButton;
    @FXML
    public void initialize() {
    }
    @FXML
    public void beginning() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/atmMachine.fxml"));
        Stage stage = (Stage)startButton.getScene().getWindow();
        stage.setTitle("ATM");
        stage.setScene(new Scene(root, 450, 475));
        stage.setResizable(false);
        stage.show();
    }

    public void showCredits(ActionEvent actionEvent) {
    }

    public void showRules(ActionEvent actionEvent) {
    }

    public void quit(ActionEvent actionEvent) {

    }
}
