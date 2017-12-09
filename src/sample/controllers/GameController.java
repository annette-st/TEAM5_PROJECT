package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import sample.classes.Student;

import java.io.IOException;

public class GameController {
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
    Student mainHero = new Student(70,70,70,70);

    @FXML
    ProgressBar energyBar;
    @FXML
    ProgressBar foodBar;
    @FXML
    ProgressBar uniBar;
    @FXML
    ProgressBar moneyBar;

    @FXML
    public void initialize(){
        energyBar.setProgress(mainHero.getEnergy());
        foodBar.setProgress(mainHero.getSatiety());
        uniBar.setProgress(mainHero.getUniversity());
        moneyBar.setProgress(mainHero.getMoney());
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
        moneyBar.setProgress(mainHero.getMoney());
        System.out.println("I've studied");
    }
    @FXML
    public void goToSleep() throws IOException{
        mainHero.toSleep();
        energyBar.setProgress(mainHero.getEnergy());
        foodBar.setProgress(mainHero.getSatiety());
        uniBar.setProgress(mainHero.getUniversity());
        moneyBar.setProgress(mainHero.getMoney());
        System.out.println("I've slept well");
    }
    @FXML
    public void haveMeal() throws IOException{
        mainHero.toEat();
        energyBar.setProgress(mainHero.getEnergy());
        foodBar.setProgress(mainHero.getSatiety());
        uniBar.setProgress(mainHero.getUniversity());
        moneyBar.setProgress(mainHero.getMoney());
        System.out.println("I've eaten");
    }
    @FXML
    public void exit() throws IOException{
        System.exit(1);
    }
}
