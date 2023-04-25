/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Charite;
import entities.Don;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import services.ChariteService;
import services.DonService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjoutChariteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane addCharitePane;
    
    
    @FXML
    void return_ListCharite()throws IOException{ 
        Parent fxml= FXMLLoader.load(getClass().getResource("listCharite.fxml"));
        addCharitePane.getChildren().removeAll();
        addCharitePane.getChildren().setAll(fxml);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    @FXML
    private Button btnAddCharite;

    @FXML
    private Button btnClearCharite;

    @FXML
    private Button btnReturnCharite;

    @FXML
    private TextField txtLieuCharite;

    @FXML
    private TextField txtNomCharite;

    @FXML
    private TextField txtTypeCharite;
    
    
    @FXML
    private void AjoutCharite(ActionEvent event) {
        //check if not empty
        if(event.getSource() == btnAddCharite){
            if (txtLieuCharite.getText().isEmpty() || txtNomCharite.getText().isEmpty() || txtTypeCharite.getText().isEmpty()) 
            {    
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Information manquante");
                alert.setHeaderText(null);
                alert.setContentText("Vous devez remplir tous les détails concernant votre Charité.");
                Optional<ButtonType> option = alert.showAndWait();
                
            } else {
                ajouterCharite();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Ajouté avec succès");
                alert.setHeaderText(null);
                alert.setContentText("Votre charité a été ajoutée avec succès.");
                Optional<ButtonType> option = alert.showAndWait();
                
                clearFieldsCharite();
            }
        }
        if(event.getSource() == btnClearCharite){
            clearFieldsCharite();
        }
    }
    
    
    @FXML
    private void clearFieldsCharite() {
        txtTypeCharite.clear();
        txtNomCharite.clear();
        txtLieuCharite.clear();
    }
    
    
    private void ajouterCharite() {
        
         // From Formulaire
        
        String nom = txtNomCharite.getText();
        String lieu = txtLieuCharite.getText();
        String type = txtTypeCharite.getText();
       
        
        Charite c = new Charite(
                nom, lieu, type);
        ChariteService cs = new ChariteService();
        cs.ajouter(c);
    }
    
}
