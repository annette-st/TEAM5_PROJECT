package sample.classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.GameController;
import sample.controllers.MenuController;

import java.io.IOException;

public class Tiredness1 extends Thread {
    GameController controller = new GameController();
    //MenuController menuController = new MenuController();
    @Override
    public void run() {
        //этот метод означает, что через определенное кол-во времени человек будет уставать и голодать
        //метод выполняется в background режиме

            try {

                sleep(1);


            } catch (InterruptedException e) {
            }
        Sound.playSound("src/sound.aif").join();
//        if((controller.mainHero.getUniversity() <= 0) || (controller.mainHero.getSatiety() <= 0) || (controller.mainHero.getEnergy() <= 0)) {
//            controller.uniButton.setDisable(true);
//            controller.eatingButton.setDisable(true);
//            controller.hackButton.setDisable(true);
//            controller.sleepButton.setDisable(true);
//        }

        //также если у нас будет реализация времени, то можно реализовать ее здесь
    }
}


