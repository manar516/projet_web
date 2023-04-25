/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Charite;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import services.ChariteService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ListChariteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane listCharitePane;
    
    @FXML
    void open_addCharite(ActionEvent event) throws IOException {
        Parent fxml= FXMLLoader.load(getClass().getResource("ajoutCharite.fxml"));
        listCharitePane.getChildren().removeAll();
        listCharitePane.getChildren().setAll(fxml);
    }
    
    @FXML
    void open_Stat(ActionEvent event) throws IOException {
        Parent fxml= FXMLLoader.load(getClass().getResource("Statistiques.fxml"));
        listCharitePane.getChildren().removeAll();
        listCharitePane.getChildren().setAll(fxml);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficherCharite();
    }   
    
    
    @FXML
    private TableColumn<Charite, String> CellLieuCharite;

    @FXML
    private TableColumn<Charite, String> CellNomCharite;

    @FXML
    private TableColumn<Charite, String> CellTypeCharite;

    @FXML
    private Button btnAjoutCharite;

    @FXML
    private Button btnDeleteCharite;


    @FXML
    private TableView<Charite> tableCharite;

    @FXML
    private TextField txtSearchCharite;
    
    
    
    ObservableList<Charite> dataCharite = FXCollections.observableArrayList();
    
    
    public void AfficherCharite()
    {
        ChariteService cs = new ChariteService();
        cs.Afficher().stream().forEach((p) -> {
            dataCharite.add(p);
        });
        CellNomCharite.setCellValueFactory(new PropertyValueFactory<>("nom_charite"));
        CellNomCharite.setCellFactory(TextFieldTableCell.forTableColumn());
        CellNomCharite.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Charite, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Charite, String> event) {
                Charite c = event.getRowValue();
                c.setNom_charite(event.getNewValue());
                ChariteService cs = new ChariteService();
                cs.modifier(c);
            }
        });
        CellLieuCharite.setCellValueFactory(new PropertyValueFactory<>("lieu_charite"));
        CellLieuCharite.setCellFactory(TextFieldTableCell.forTableColumn());
        CellLieuCharite.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Charite, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Charite, String> event) {
                Charite c = event.getRowValue();
                c.setLieu_charite(event.getNewValue());
                ChariteService cs = new ChariteService();
                cs.modifier(c);
            }
        });
        CellTypeCharite.setCellValueFactory(new PropertyValueFactory<>("type_charite"));
        CellTypeCharite.setCellFactory(TextFieldTableCell.forTableColumn());
        CellTypeCharite.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Charite, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Charite, String> event) {
                Charite c = event.getRowValue();
                c.setType_charite(event.getNewValue());
                ChariteService cs = new ChariteService();
                cs.modifier(c);
            }
        });
        
        
        tableCharite.setItems(dataCharite);
        
        try {
            searchCharite();
        } catch (SQLException ex) {
            Logger.getLogger(ListDonController.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    
    
    
    @FXML
    private void supprimerCharite(ActionEvent event) throws SQLException {
        ChariteService cs = new ChariteService();
        
        if (tableCharite.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez sélectionner la Charite à supprimer");
            alert.showAndWait();
            return;
        }

        // Afficher une boîte de dialogue de confirmation
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment supprimer cette Charite ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Récupérer l'ID de le Don sélectionnée dans la vue de la table
            int id = tableCharite.getSelectionModel().getSelectedItem().getId_charite();

            // Supprimer le don de la base de données
            cs.supprimer(id);
            // Rafraîchir la liste de données
            dataCharite.clear();
            AfficherCharite();
            // Rafraîchir la vue de la table
            tableCharite.refresh();
        }
    }
    
    
    
    public ChariteService cs = new ChariteService();
    
    public void searchCharite() throws SQLException {    
        FilteredList<Charite> filteredData = new FilteredList<>(FXCollections.observableArrayList(cs.Afficher()), p -> true);
        txtSearchCharite.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(cha -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String nom = String.valueOf(cha.getNom_charite());
                String lieu = String.valueOf(cha.getLieu_charite());
                String type = String.valueOf(cha.getType_charite());
                String lowerCaseFilter = newValue.toLowerCase();

                if (nom.toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (lieu.toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (type.toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<Charite> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableCharite.comparatorProperty());
        tableCharite.setItems(sortedData);
    }
    
    
    
}
