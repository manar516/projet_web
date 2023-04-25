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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import services.ChariteService;
import services.DonService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjoutDonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane addDonPane;
    
    
    @FXML
    void return_ListDon()throws IOException{ 
        Parent fxml= FXMLLoader.load(getClass().getResource("listDon.fxml"));
        addDonPane.getChildren().removeAll();
        addDonPane.getChildren().setAll(fxml);
    }
    
    
    ChariteService cs = new ChariteService();
    List<Charite> charite = cs.Afficher();
    private int chariteId=-1;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Map<String, Integer> valuesMap = new HashMap<>();
        for(Charite c : charite){
            textCharite.getItems().add(c.getNom_charite());
            valuesMap.put(c.getNom_charite(),c.getId_charite());
        }
        
        textCharite.setOnAction(event ->{
            String SelectedOption = null;
            SelectedOption = textCharite.getValue();
            int SelectedValue = 0;
            SelectedValue = valuesMap.get(SelectedOption);
            chariteId = SelectedValue;
        });
    }    
    
    
    @FXML
    private Button btnAddDon;

    @FXML
    private Button btnClearDon;

    @FXML
    private Button btnReturnDon;

    @FXML
    private ComboBox<String> textCharite;

    @FXML
    private ComboBox<Integer> textUser;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtType;
    
    
    @FXML
    private void AjoutDon(ActionEvent event) {
        //check if not empty
        if(event.getSource() == btnAddDon){
            if (chariteId==-1 || txtDescription.getText().isEmpty() || txtType.getText().isEmpty() ) 
            {    
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Information manquante");
                alert.setHeaderText(null);
                alert.setContentText("Vous devez remplir tous les détails concernant votre don.");
                Optional<ButtonType> option = alert.showAndWait();
                
            } else {
                ajouterDon();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Ajouté avec succès");
                alert.setHeaderText(null);
                alert.setContentText("Votre don a été ajoutée avec succès.");
                Optional<ButtonType> option = alert.showAndWait();
                send_SMS();
                clearFieldsDon();
            }
        }
        if(event.getSource() == btnClearDon){
            clearFieldsDon();
        }
    }
    
    
    @FXML
    private void clearFieldsDon() {
        txtDescription.clear();
        txtType.clear();
    }
    
    
    private void ajouterDon() {
        
         // From Formulaire
        int charite = chariteId;
        int user =1;
        
        
        String typeDon = txtType.getText();
        String descriptionDon = txtDescription.getText();
       
        
        Don d = new Don(
                charite, user, typeDon, descriptionDon);
        DonService ds = new DonService();
        ds.ajouter(d);
    }
    
    
    void send_SMS (){
        // Initialisation de la bibliothèque Twilio avec les informations de votre compte
        String ACCOUNT_SID = "ACb30ed969939bf77a1576ebb470a71acc";
        String AUTH_TOKEN = "8e3370ad77818d0a634b678cef99f4f4";
             
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            String recipientNumber = "+21652941883";
            String message = "Bonjour Mr ,\n"
                    + "Nous sommes ravis de vous informer que votre don a été ajouté.\n "
                    + "Veuillez contactez l'administration pour plus de details.\n "
                    + "Merci de votre fidélité et à bientôt chez Charite.\n"
                    + "Cordialement,\n"
                    + "Charite";
                
            Message twilioMessage = Message.creator(
                new PhoneNumber(recipientNumber),
                new PhoneNumber("+16074246285"),message).create();
                
            System.out.println("SMS envoyé : " + twilioMessage.getSid());
            /*TrayNotificationAlert.notif("Coupon", "Coupon sent successfully.",
            NotificationType.SUCCESS, AnimationType.POPUP, Duration.millis(2500));*/

        
         
     }
    
}
