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

import java.io.FileReader;
import java.io.IOException;

public class GameController {

    int[] inputID = new int[]{0, 0, 0, 0};

    public void setEnteredNumber(int enteredNumber) {
        this.enteredNumber = enteredNumber;
    }

    public int enteredNumber;

    int input = 10;

    boolean enter = false;
    int count = 0;
    //Thread th = new

    public static Student mainHero = new Student(0.7, 0.7, 0.7, 200);

    @FXML
    public Label moneyLabel;
    @FXML
    private Button quitButton;
    @FXML
    public Button uniButton;
    @FXML
    public Button sleepButton;
    @FXML
    public Button hackButton;
    @FXML
    public Button eatingButton;

    @FXML
    ProgressBar energyBar;
    @FXML
    ProgressBar foodBar;
    @FXML
    ProgressBar uniBar;

    @FXML
    public void initialize() {
        energyBar.setProgress(mainHero.getEnergy());
        foodBar.setProgress(mainHero.getSatiety());
        uniBar.setProgress(mainHero.getUniversity());
        moneyLabel.setText(String.valueOf(mainHero.getMoney()));

    }

    @FXML
    public void hack() throws IOException, InterruptedException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/AtmMachine.fxml"));
        Stage stage = (Stage) hackButton.getScene().getWindow();
        stage.setTitle("It's Time to Hack");
        stage.setScene(new Scene(root, 1000, 600));
        stage.setResizable(false);
        stage.show();

        int[] cardID = mainHero.toHackGeneration();


        //Random rnd = new Random(System.currentTimeMillis());
        final int ATTEMPTS = 4; //кол-во попыток

        boolean end = false; // конец игры (true - игра кончилась с положительным исходом, false - с отрицательным)
        //что будет выводиться


        //попытка на который сейчас игрок
        int thisAttempt;
        //игра
        for (thisAttempt = 0; thisAttempt < ATTEMPTS; thisAttempt++) {

            int c;
//            try (FileReader reader = new FileReader("src/input.txt")) {
//                // читаем посимвольно
//                int k = 0;
//                do {
//                    c = reader.read();
//                    System.out.print((char) c);
//                    k++;
//                } while (!enter);
//            } catch (IOException ex) {
//
//                System.out.println(ex.getMessage());
//            }

            char[] output = mainHero.toHackBulls(enteredNumber, cardID);

            for (int i = 0; i < output.length; i++) {
                System.out.print(output[i]);
            }

            boolean cowdigit[] = mainHero.getCowdigit();

            System.out.println(" ");
            System.out.print("Коровы: ");
            for (int i = 0; i < cowdigit.length; i++) {
                if (cowdigit[i] == true)
                    System.out.print(i + " ");
            }

            //высчитывание конца игры(проверка на полное совпадение 2 кодов - рандомного и вводимого)
            end = true;
            for (int i = 0; i < cardID.length; i++) {
                if (output[i] != Character.forDigit(cardID[i], 10))
                    end &= false;
            }

            //if (end == true) break;


            //принты


//            System.out.println(" ");
//            for(int i = 0; i < inputID.length; i++) {
//                System.out.println(inputID[i]);
//            }
        }
    }

    @FXML
    public void goToUni() throws IOException {
        mainHero.toStudy();
        energyBar.setProgress(mainHero.getEnergy());
        foodBar.setProgress(mainHero.getSatiety());
        uniBar.setProgress(mainHero.getUniversity());
        moneyLabel.setText(String.valueOf(mainHero.getMoney()));

        System.out.println("I've studied");
    }

    @FXML
    public void goToSleep() throws IOException {
        mainHero.toSleep();
        energyBar.setProgress(mainHero.getEnergy());
        foodBar.setProgress(mainHero.getSatiety());
        uniBar.setProgress(mainHero.getUniversity());
        moneyLabel.setText(String.valueOf(mainHero.getMoney()));
        System.out.println("I've slept well");
    }

    @FXML
    public void haveMeal() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/rastaurantsWindow.fxml"));
        Stage stage = (Stage)eatingButton.getScene().getWindow();
        stage.setTitle("The Game");
        stage.setScene(new Scene(root,1000,600));
        stage.setResizable(false);
        stage.show();
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
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        }
    }
    @FXML
    public void askQuestion() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/gameQuestion.fxml"));
            stage.setTitle("Really?");
            stage.setScene(new Scene(root, 500, 300));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(quitButton.getScene().getWindow());
            stage.show();
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        }
    }

    public void setInput(int input) {
        this.input = input;
    }

    public void setEnter(boolean enter) {
        this.enter = enter;
    }

    public void settingTheInputID(){
//        int i = 0;
//        while (i<4) {
//            if (input != 10)
//        }

//    public void settingTheInputID() {
//        int i = 0;
//        while (i < 4) {
//            if (input != 10) ;
//        }

    }

//    public void


}
