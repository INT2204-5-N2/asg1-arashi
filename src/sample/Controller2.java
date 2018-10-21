package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Controller2    {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    @FXML
    private TextField TextField;
    @FXML private TextArea TextArea;

    public void Search(ActionEvent event) {
       dictionaryManagement.insertFromFile();
        String voc = TextField.getText();
        voc =voc.trim();
        int temp1 =0;
        for(int i=0;i<dictionaryManagement.getDsData().size();i++)
        {
            if(dictionaryManagement.getDsData().get(i).getWord_target().compareToIgnoreCase(voc)==0)
            {
                temp1 ++;
                TextArea.setText(dictionaryManagement.getDsData().get(i).getWord_explain());
                break;
            }
            if(i== dictionaryManagement.getDsData().size()-1 && temp1==0)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Từ "+"' "+ voc +" '" + " không tồn tại !!!");
                alert.show();
            }
        }
        dictionaryManagement.Sort();
    }
    // nghe rồi
    // địt mẹ nói đi

    public void enterDelete(ActionEvent event) throws IOException {
         Stage stage1 = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("delete.fxml"));
        Parent parent1 = loader.load();
        Scene scene1 = new Scene(parent1);
        stage1.setScene(scene1);
        stage1.show();
    }
    public void enterMore(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("more.fxml"));
        Parent parent1 = loader.load();
        Scene scene1 = new Scene(parent1);
        stage1.setScene(scene1);
        stage1.show();
    }
    public void enterChance(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("chance.fxml"));
        Parent parent1 = loader.load();
        Scene scene1 = new Scene(parent1);
        stage1.setScene(scene1);
        stage1.show();
    }
}
