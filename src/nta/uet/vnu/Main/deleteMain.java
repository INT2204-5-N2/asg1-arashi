package nta.uet.vnu.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class deleteMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent stage = FXMLLoader.load(getClass().getResource("../Controller/delete.fxml"));
        Scene scene = new Scene(stage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
