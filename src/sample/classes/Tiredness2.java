package sample.classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.MenuController;

import java.io.IOException;

public class Tiredness2 extends Thread {
    //MenuController menuController = new MenuController();

    public void sceneForVideo(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/VideoWindow.fxml"));
        primaryStage.setTitle("End Of The Game");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.setResizable(false);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(1000);
        primaryStage.show();
    }
    @Override
    public void run() {
        //этот метод означает, что через определенное кол-во времени человек будет уставать и голодать
        //метод выполняется в background режиме

        try {

            sleep(1);


        } catch (InterruptedException e) {
        }


        //Sound.playSound("src/sound.aif").join();


        //также если у нас будет реализация времени, то можно реализовать ее здесь
    }
}

