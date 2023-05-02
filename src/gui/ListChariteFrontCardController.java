/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Charite;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author azizo
 */
public class ListChariteFrontCardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private Label labelLieuCharite;

    @FXML
    private Label labelNomCharite;

    @FXML
    private Label labelTypeCharite;
    
    MyListener myListener;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    Charite charite;
    
    public void setData (Charite charite, MyListener myListener){
        this.charite = charite ;
        this.myListener = myListener;
        
        labelNomCharite.setText(charite.getNom_charite());
        labelLieuCharite.setText(charite.getLieu_charite());
        labelTypeCharite.setText(charite.getType_charite());
        
    }
    
}
