package nta.uet.vnu.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nta.uet.vnu.Commandline.FreeTTS;
import nta.uet.vnu.Commandline.googleAPI;

import java.io.IOException;

public class googleAPIController {
    @FXML private TextField textField;
    @FXML private TextArea textArea2;
    public void backDic(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Layout.fxml"));
        Parent parent1 = loader.load();
        Scene scene1 = new Scene(parent1);
        stage1.setScene(scene1);
        stage1.show();
    }
    public void Translate(ActionEvent event){
        try
        {
            googleAPI a = new googleAPI();
            String m = a.translate("en","vi",textField.getText());
            textArea2.setText(m);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void ReadText1(ActionEvent event) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        FreeTTS freeTTS = new FreeTTS(FreeTTS.VOICE_KEVIN);
        freeTTS.open();
        freeTTS.speak(textField.getText());
        freeTTS.close();
    }
}
