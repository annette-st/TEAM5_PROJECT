package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.controllers.GameController;

import java.io.IOException;

public class AtmController {

    GameController gameController = new GameController();
    int array[] = new int[4];
    int count = 0;
    // label aer down here
    @FXML
    private Label enteredText;

    //All navigation button are down here
    @FXML
    private Button backButton;
    @FXML
    private Button questionButton;
    @FXML
    private Button exitButton;

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
    public void exit() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/youWannaExit.fxml"));
            stage.setTitle("Are you sure?");
            stage.setScene(new Scene(root, 500, 300));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(exitButton.getScene().getWindow());
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
//        gameController.exit();
    }

    // All the insert buttons are down here
    @FXML
    public void insertOne () {
        if(count < array.length) {
            array[count++] = 1;
        }
//        enteredText.setText(()(gameController.mainHero.getInput()));
    }
    public void insertTwo () {
        if(count < array.length) {
            array[count++] = 2;
        }
    }
    public void insertThree () {
        if(count < array.length) {
            array[count++] = 3;
        }
    }
    public void insertFour () {
        if(count < array.length) {
            array[count++] = 4;
        }
    }
    public void insertFive () {
        gameController.mainHero.setInput(5);
    }
    public void insertSix () {
        gameController.mainHero.setInput(6);
    }
    public void insertSeven () {
        gameController.mainHero.setInput(7);
    }
    public void insertEight () {
        gameController.mainHero.setInput(8);
    }
    public void insertNine () {
        gameController.mainHero.setInput(9);
    }
    public void insertZero () {
        gameController.mainHero.setInput(0);
    }
    public void cancelInput() {
        System.out.println("I've canceled");
    }
    public void enterInput() {
        gameController.mainHero.toHack(array);
    }

}
