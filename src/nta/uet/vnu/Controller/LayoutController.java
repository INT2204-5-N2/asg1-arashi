package nta.uet.vnu.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nta.uet.vnu.Commandline.DictionaryManagement;
import nta.uet.vnu.Commandline.FreeTTS;

import java.io.IOException;
import java.util.List;

public class LayoutController {
    @FXML
    private TextField textField;
    @FXML
    private javafx.scene.control.TextArea textArea;
    @FXML private ListView listView;
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public void enterDelete(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("delete.fxml"));
        Parent parent1 = loader.load();
        Scene scene1 = new Scene(parent1);
        stage1.setScene(scene1);
        stage1.show();
    }
    public void enterMores(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("mores.fxml"));
        Parent parent1 = loader.load();
        Scene scene1 = new Scene(parent1);
        stage1.setScene(scene1);
        stage1.show();
    }

    public void enterChance(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("chance.fxml"));
        Parent parent3 = loader.load();
        Scene scene1 = new Scene(parent3);
        stage1.setScene(scene1);
        stage1.show();
    }
    public void searchWord(ActionEvent event){
    List DS = dictionaryManagement.getDsData();
        ObservableList<String> listWord = FXCollections.observableArrayList(DS);
        FilteredList<String> filteredData = new FilteredList<>(listWord, s -> true);
        listView.setItems(filteredData);
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(s -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String tolower = newValue.toLowerCase();
                if (s.toLowerCase().startsWith(tolower)) {
                    return true;
                }
                return false;
            });
            listView.setItems(filteredData);
        });
    }

    public void Search(ActionEvent event) {
        dictionaryManagement.insertFromFile();
        String voc = textField.getText();
        voc = voc.trim();
        int temp = 0;
        for (int i = 0; i < dictionaryManagement.getDsData().size(); i++) {
            if (dictionaryManagement.getDsData().get(i).getWord_target().compareToIgnoreCase(voc) == 0) {
                temp++;
                textArea.setText(dictionaryManagement.getDsData().get(i).getWord_explain());
                break;
            }
            if (i == dictionaryManagement.getDsData().size() - 1 && temp == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Từ muốn tìm không tồn tại!!!");
                alert.show();
            }
        }
    }

    public void ReadText(ActionEvent event) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        FreeTTS freeTTS = new FreeTTS(FreeTTS.VOICE_KEVIN);
        freeTTS.open();
        freeTTS.speak(textField.getText());
        freeTTS.close();
    }
    public void enterTextToGoogle(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("googleAPI.fxml"));
        Parent parent1 = loader.load();
        Scene scene1 = new Scene(parent1);
        stage1.setScene(scene1);
        stage1.show();
    }

}
