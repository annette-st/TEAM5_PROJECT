package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/mainWindow.fxml"));
        primaryStage.setTitle("The Game");
        primaryStage.setScene(new Scene(root, 450, 475));
        primaryStage.setResizable(false);
//        primaryStage.setMinHeight(475);
//        primaryStage.setMinWidth(450);
//        primaryStage.setMaxHeight(475);
//        primaryStage.setMaxWidth(450);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);

        Student student = new Student(100, 100, 100, 100);
        student.toHack();
    }
}
