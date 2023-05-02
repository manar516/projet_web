/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FrontChariteControler implements Initializable {

    @FXML
    private AnchorPane content_areaFront;
    
    @FXML
    private Pane content_area;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    void open_listeOffre(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("listCharitee.fxml"));
        content_area.getChildren().removeAll();
        content_area.getChildren().setAll(fxml);

    }
    
}
