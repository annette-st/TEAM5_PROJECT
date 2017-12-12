package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class AtmController {
    //All navigation button are down here
    @FXML
    private Button backButton;
    @FXML
    private Button questionButton;

    // Insert buttons are down here
    @FXML
    private Button cancelButton;
    private Button enterButton;

    @FXML
    public void initialize(){
    }
    @FXML
    public void back() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/mainWindow.fxml"));
        Stage stage = (Stage)backButton.getScene().getWindow();
        stage.setTitle("The Game");
        stage.setScene(new Scene(root, 1000, 600));
        stage.setResizable(true);
        stage.show();
    }
    @FXML
    public void whatsHappenning() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/rulesWindow.fxml"));
        Stage stage = (Stage)questionButton.getScene().getWindow();
        stage.setTitle("Read and try to understand");
        stage.setScene(new Scene(root, 1000, 600));
        stage.setResizable(true);
        stage.show();
    }

    // All the insert buttons are down here
    @FXML
    public void cancelInput() {
        System.out.println("I've canceled");
    }
    public void enterInput() {
        System.out.println("I've entered");
    }
}
