/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Charite;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import services.ChariteService;

/**
 * FXML Controller class
 *
 * @author azizo
 */
public class ListChariteFrontController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private MyListener myListener;
    
    @FXML
    private Pagination pag;
    
    @FXML
    private AnchorPane listChariteFront;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ChariteService cs = new ChariteService();
            List<Charite> cha = cs.Afficher();
            pag.setPageCount((int) Math.ceil(cha.size() / 3.0)); // Nombre total de pages nécessaire pour afficher toutes les cartes
            pag.setPageFactory(pageIndex -> {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                hbox.setAlignment(Pos.CENTER);
                int itemsPerPage = 3; // Nombre d'articles à afficher par page
                int page = pageIndex * itemsPerPage;
                for (int i = page; i < Math.min(page + itemsPerPage, cha.size()); i++) {
                    
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("listChariteFrontCard.fxml"));
                        AnchorPane anchorPane = fxmlLoader.load();
                        anchorPane.getStyleClass().add("ct");
                        ListChariteFrontCardController itemController = fxmlLoader.getController();
                        itemController.setData(cha.get(i), myListener);
                        hbox.getChildren().add(anchorPane);
                        HBox.setMargin(anchorPane, new Insets(10)); // Marges entre les cartes
                    } catch (IOException ex) {
                        Logger.getLogger(ListChariteFrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                return hbox;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }        
    
}
