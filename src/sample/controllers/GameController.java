package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.classes.Student;

import java.io.IOException;

public class GameController {

    public static Student mainHero = new Student(0.7,0.7,0.7,200);
    @FXML
    public Label moneyLabel;
    @FXML
    private Button quitButton;
    @FXML
    private Button uniButton;
    @FXML
    private Button sleepButton;
    @FXML
    private Button hackButton;
    @FXML
    private Button eatingButton;

    @FXML
    ProgressBar energyBar;
    @FXML
    ProgressBar foodBar;
    @FXML
    ProgressBar uniBar;

    @FXML
    public void initialize(){
        energyBar.setProgress(mainHero.getEnergy());
        foodBar.setProgress(mainHero.getSatiety());
        uniBar.setProgress(mainHero.getUniversity());
    }

    @FXML
    public void hack() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/AtmMachine.fxml"));
        Stage stage = (Stage)hackButton.getScene().getWindow();
        stage.setTitle("It's Time to Hack");
        stage.setScene(new Scene(root, 1000, 600));
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void goToUni() throws IOException{
        mainHero.toStudy();
        energyBar.setProgress(mainHero.getEnergy());
        foodBar.setProgress(mainHero.getSatiety());
        uniBar.setProgress(mainHero.getUniversity());
        moneyLabel.setText(String.valueOf(mainHero.getMoney()));

        System.out.println("I've studied");
    }
    @FXML
    public void goToSleep() throws IOException{
        mainHero.toSleep();
        energyBar.setProgress(mainHero.getEnergy());
        foodBar.setProgress(mainHero.getSatiety());
        uniBar.setProgress(mainHero.getUniversity());
        moneyLabel.setText(String.valueOf(mainHero.getMoney()));
        System.out.println("I've slept well");
    }
    @FXML
    public void haveMeal() throws IOException{
        mainHero.toEat();
        energyBar.setProgress(mainHero.getEnergy());
        foodBar.setProgress(mainHero.getSatiety());
        uniBar.setProgress(mainHero.getUniversity());
        moneyLabel.setText(String.valueOf(mainHero.getMoney()));
        System.out.println("I've eaten");
    }
    @FXML
    public void exit() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/youWannaExit.fxml"));
            stage.setTitle("Really?");
            stage.setScene(new Scene(root, 500, 300));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(quitButton.getScene().getWindow());
            stage.show();
        } catch(IOException e) {
//            e.printStackTrace();
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        }
    }
}
