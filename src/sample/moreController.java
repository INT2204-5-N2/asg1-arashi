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

public class moreController {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    @FXML private TextField FXMLthemtienganh;
    @FXML private TextField FXMLthemtiengviet;
    public void backDic(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample2.fxml"));
        Parent parent1 = loader.load();
        Scene scene1 = new Scene(parent1);
        stage1.setScene(scene1);
        stage1.show();
    }
    public void add(ActionEvent event){
        dictionaryManagement.insertFromFile();
        Word w1 = new Word();
        w1.setWord_target(FXMLthemtienganh.getText());
        String s = FXMLthemtienganh.getText();
        w1.setWord_explain(FXMLthemtiengviet.getText());
        int temp =0;
        for(int i =0;i<dictionaryManagement.getDsData().size();i++)
        {
            if(dictionaryManagement.getDsData().get(i).getWord_target().equals(w1.getWord_target())== true && dictionaryManagement.getDsData().get(i).getWord_explain().equals(w1.getWord_explain())==true) {
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setContentText(s + " đã có trong từ điển!!");
                alert2.show();
                temp ++;
                break;
            }
        }
        if(temp == 0)
        {
            dictionaryManagement.getDsData().add(w1);
            dictionaryManagement.SaveToFile();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Thêm từ " + s + " thành công!!!");
            alert.show();
        }
        else{
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setContentText("Thêm từ thất bại!!");
        alert1.show();
        }
    }
}
