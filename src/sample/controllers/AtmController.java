package sample.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.FileWriter;
import sample.controllers.GameController;

import java.io.IOException;

public class AtmController {

    GameController gameController = new GameController();

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
            Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/atmQuestion.fxml"));
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
        gameController.setInput(1);
//        enteredText.setText(()(gameController.mainHero.getInput()));
    }
    public void insertTwo () {
        gameController.setInput(2);
    }
    public void insertThree () {
        gameController.setInput(3);
    }
    public void insertFour () {
        gameController.setInput(4);
    }
    public void insertFive () {
        gameController.setInput(5);
    }
    public void insertSix () {
        gameController.setInput(6);
    }
    public void insertSeven () {
        gameController.setInput(7);
    }
    public void insertEight () {
        gameController.setInput(8);
    }
    public void insertNine () {
        gameController.setInput(9);
    }
    public void insertZero () {
        gameController.setInput(0);
    }

    public void cancelInput() {
        System.out.println("I've canceled");
    }

    public void enterInput() {
        gameController.setEnter(true);
    }

    public void writeToFile() {

//        FileWriter writer = new FileWriter("output.txt");
//
//
//
//         writer.close();
    }


}
