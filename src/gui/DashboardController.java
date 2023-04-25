/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author ASUS
 */
public class DashboardController implements Initializable {
    
    @FXML
    private Button btnHome;
    @FXML
    private Button btnDon;
    @FXML
    private Button btnCharite;
    @FXML
    private AnchorPane viewPages;
    
    
    @FXML
    public void switchForm(ActionEvent event) throws IOException{
        if(event.getSource()== btnDon){
            Parent fxml= FXMLLoader.load(getClass().getResource("listDon.fxml"));
            viewPages.getChildren().removeAll();
            viewPages.getChildren().setAll(fxml);
        }else if(event.getSource()==btnCharite){
            Parent fxml= FXMLLoader.load(getClass().getResource("listCharite.fxml"));
            viewPages.getChildren().removeAll();
            viewPages.getChildren().setAll(fxml);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
