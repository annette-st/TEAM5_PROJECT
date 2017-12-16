package sample.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.Font;
import java.awt.event.*;
import java.awt.FlowLayout;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import sample.controllers.GameController;

public class AtmController {
    GameController gameController = new GameController();

    // label aer down here
    @FXML
    public TextField enteredText;
    @FXML
    public static Label generatedPinLabel;
    @FXML
    public static Label cowsLabel;

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
    public Button enterButton;

    @FXML
    public void initialize() {
    }

    @FXML
    public void back() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/gameWindow.fxml"));
        Stage stage = (Stage) backButton.getScene().getWindow();
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
        } catch (IOException e) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
//        gameController.exit();
    }

    // All the insert buttons are down here
    @FXML
    public void insertOne() {

        gameController.mainHero.setInput(1);
//        writeToFile(1);
        enteredText.setText(String.valueOf(gameController.mainHero.getInput()));
    }
    public void insertTwo() {
//        writeToFile(2);
        gameController.mainHero.setInput(2);
        enteredText.setText(String.valueOf(gameController.mainHero.getInput()));
    }
    public void insertThree() {
//        writeToFile(3);
        gameController.mainHero.setInput(3);
        enteredText.setText(String.valueOf(gameController.mainHero.getInput()));
    }
    public void insertFour() {
//        writeToFile(4);
        gameController.mainHero.setInput(4);
        enteredText.setText(String.valueOf(gameController.mainHero.getInput()));
    }
    public void insertFive() {
//        writeToFile(5);
        gameController.mainHero.setInput(5);
        enteredText.setText(String.valueOf(gameController.mainHero.getInput()));
    }
    public void insertSix() {
//        writeToFile(6);
        gameController.mainHero.setInput(6);
        enteredText.setText(String.valueOf(gameController.mainHero.getInput()));
    }
    public void insertSeven() {
//        writeToFile(7);
        gameController.mainHero.setInput(7);
        enteredText.setText(String.valueOf(gameController.mainHero.getInput()));
    }
    public void insertEight() {
//        writeToFile(8);
        gameController.mainHero.setInput(8);
        enteredText.setText(String.valueOf(gameController.mainHero.getInput()));
    }
    public void insertNine() {
//        writeToFile(9);
        gameController.mainHero.setInput(9);
        enteredText.setText(String.valueOf(gameController.mainHero.getInput()));
    }
    public void insertZero() {
//        writeToFile(0);
        gameController.mainHero.setInput(0);
        enteredText.setText(String.valueOf(gameController.mainHero.getInput()));
    }

    public void cancelInput() {
        System.out.println("I've canceled");
    }

    public void enterInput() {

//        int enteredNumber = Integer.parseInt(enteredText.getText());
//        gameController.setEnteredNumber(enteredNumber);
        gameController.mainHero.toGetGift();
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/DontHack.fxml"));
            stage.setTitle("Don't do that");
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(enterButton.getScene().getWindow());
            stage.show();
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        }
//        cycle.clear();
        //gameController.setEnter(true);
        //writeToFile("c");
    }


//        FileWriter writer = new FileWriter("output.txt");
//
//
//
//         writer.close();
    public void writeToFile(int c) {

        try (FileWriter writer = new FileWriter("src/input.txt", true)) {
            // запись всей строки
            String text = "Мама мыла раму, раму мыла мама";
            writer.write(String.valueOf(c));
            // запись по символам
            //writer.append('\n');
            //writer.append('E');

            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void writeToFile(String c) {

        try (FileWriter writer = new FileWriter("src/input.txt", true)) {
            // запись всей строки
            String text = "Мама мыла раму, раму мыла мама";
            writer.write(c);
            // запись по символам
            //writer.append('\n');
            //writer.append('E');

            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
