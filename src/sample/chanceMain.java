package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class chanceMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("chance.fxml"));
        primaryStage.setTitle("Sửa Từ");
        Scene scene1 = new Scene(root1);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
}
