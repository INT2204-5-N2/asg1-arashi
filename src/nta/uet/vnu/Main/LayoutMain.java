package nta.uet.vnu.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LayoutMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource("../Controller/Layout.fxml"));
    primaryStage.setTitle("DICTIONARY.exe");
    Scene scene = new Scene(parent);
    primaryStage.setScene(scene);
    primaryStage.show();
    }

}
