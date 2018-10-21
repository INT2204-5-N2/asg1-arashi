package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class deleteController {
    @FXML private TextField FXMLxoatienganh;
    @FXML private TextField FXMLxoatiengviet;
    public void delete(ActionEvent event){
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.insertFromFile();
        int temp =1;
        String tu =FXMLxoatienganh.getText();
        String nghia =FXMLxoatiengviet.getText();
        Word w = new Word(tu, nghia);
        for (int i = 0; i < dictionaryManagement.getDsData().size(); i++) {
            if (dictionaryManagement.getDsData().get(i).getWord_target().equals(w.getWord_target())==true && dictionaryManagement.getDsData().get(i).getWord_explain().equals( w.getWord_explain()) ==true) {
                dictionaryManagement.getDsData().remove(i);
                temp++;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("' "+ tu +" '"+" đã được xóa!!!");
                alert.show();
                break;
            }
        }
        if(temp ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Xóa Từ Thất Bại!!!");
            alert.show();
        }
        dictionaryManagement.SaveToFile();

    }
    public void backDic(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample2.fxml"));
        Parent parent1 = loader.load();
        Scene scene1 = new Scene(parent1);
        stage1.setScene(scene1);
        stage1.show();
    }
}
