package sample.classes;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.controllers.MenuController;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Tiredness2 extends Thread {

    @Override
    public void run() {
        //этот метод означает, что через определенное кол-во времени человек будет уставать и голодать
        //метод выполняется в background режиме

        try {
            sleep(1);
        } catch (InterruptedException e) {
        }
        System.out.println("xui");

    }

//

        //Sound.playSound("src/sound.aif").join();


        //также если у нас будет реализация времени, то можно реализовать ее здесь
    }


