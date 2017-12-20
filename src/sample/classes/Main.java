package sample.classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    static Tiredness tiredness; //инициализация потока

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/menuWindow.fxml"));
        primaryStage.setTitle("The Game");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.setResizable(false);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(1000);
//        primaryStage.setMaxHeight(475);
//        primaryStage.setMaxWidth(450);
        primaryStage.show();
    }


    public static void main(String[] args) throws InterruptedException {
        tiredness = new Tiredness(); //создание потока
        tiredness.start(); //запуск потока
        launch(args);
        //Thread.sleep(20000);
        Student student = new Student(100, 100, 100, 100);
        student.toHack();
        tiredness.stop();
    }
}
