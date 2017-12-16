package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class restaurantController {
    GameController gameController = new GameController();
    @FXML
    private Button backButton;
    @FXML
    private Button questionButton;
    @FXML
    private Button khanumaButton;
    @FXML
    private Button kindButton;
    @FXML
    private Button bitchButton;
    @FXML
    private Button macButton;
    @FXML
    private Button pizzaButton;
    @FXML
    private Button airButton;

    @FXML
    public void goBack() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/gameWindow.fxml"));
        Stage stage = (Stage)backButton.getScene().getWindow();
        stage.setTitle("It's your time to hack");
        stage.setScene(new Scene(root,1000,600));
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void askQuestion() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/modalHowToEat.fxml"));
            stage.setTitle("Read and try to understand");
            stage.setScene(new Scene(root, 500, 300));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(questionButton.getScene().getWindow());
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void eatAtKhanuma() throws IOException {
        gameController.mainHero.setRestaurant(2);
        gameController.mainHero.toEat();
        goBack();
    }
    @FXML
    public void eatAtKindcafe() throws IOException {
        gameController.mainHero.setRestaurant(1);
        gameController.mainHero.toEat();
        goBack();
    }
    @FXML
    public void eatBitch() throws IOException {
        gameController.mainHero.setRestaurant(3);
        gameController.mainHero.toEat();
        goBack();
    }
    @FXML
    public void eatAtMac() throws IOException {
        gameController.mainHero.setRestaurant(4);
        gameController.mainHero.toEat();
        goBack();
    }
    @FXML
    public void eatPizza() throws IOException {
        gameController.mainHero.setRestaurant(5);
        gameController.mainHero.toEat();
        goBack();
    }
    @FXML
    public void eatAir() throws IOException {
        gameController.mainHero.setRestaurant(6);
        gameController.mainHero.toEat();
        goBack();
    }
}
