package sample.controllers;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
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
    @FXML
    private Button enterButton;

    @FXML
    public void initialize(){
    }
    @FXML
    public void back() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/gameWindow.fxml"));
        Stage stage = (Stage)backButton.getScene().getWindow();
        stage.setTitle("The Game");
        stage.setScene(new Scene(root, 1000, 600));
        stage.setResizable(false);
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

    @FXML
    public void whatsHappenning() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/modalAtm.fxml"));
            stage.setTitle("Read and try to understand");
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(questionButton.getScene().getWindow());
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
