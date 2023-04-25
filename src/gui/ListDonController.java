/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Don;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.converter.IntegerStringConverter;
import services.DonService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ListDonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane listDonPane;
    
    @FXML
    void open_addDon(ActionEvent event) throws IOException {
        Parent fxml= FXMLLoader.load(getClass().getResource("ajoutDon.fxml"));
        listDonPane.getChildren().removeAll();
        listDonPane.getChildren().setAll(fxml);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficherDon();
    }    
    
    
    @FXML
    private TableColumn<Don, String> CellDescription;

    @FXML
    private TableColumn<Don, String> CellType;

    @FXML
    private TableColumn<Don, Integer> CellUser;
    
    @FXML
    private TableColumn<Don, Integer> CellCharite;
    
    @FXML
    private Button btnAjoutDon;

    @FXML
    private Button btnDeleteDon;

    @FXML
    private TableView<Don> tableDon;

    @FXML
    private TextField txtSearchDon;
    
    
    ObservableList<Don> data = FXCollections.observableArrayList();
    
    
    public void AfficherDon()
    {
        DonService ds = new DonService();
        ds.Afficher().stream().forEach((p) -> {
            data.add(p);
        });
        CellCharite.setCellValueFactory(new PropertyValueFactory<>("id_charite"));
        CellCharite.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        CellCharite.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Don, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Don, Integer> event) {
                Don d = event.getRowValue();
                d.setId_charite(event.getNewValue());
                DonService ds = new DonService();
                ds.modifier(d);
            }
        });
        CellType.setCellValueFactory(new PropertyValueFactory<>("type_dons"));
        CellType.setCellFactory(TextFieldTableCell.forTableColumn());
        CellType.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Don, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Don, String> event) {
                Don d = event.getRowValue();
                d.setType_dons(event.getNewValue());
                DonService ds = new DonService();
                ds.modifier(d);
            }
        });
        CellDescription.setCellValueFactory(new PropertyValueFactory<>("description_dons"));
        CellDescription.setCellFactory(TextFieldTableCell.forTableColumn());
        CellDescription.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Don, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Don, String> event) {
                Don d = event.getRowValue();
                d.setDescription_dons(event.getNewValue());
                DonService ds = new DonService();
                ds.modifier(d);
            }
        });
        CellUser.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        CellUser.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        CellUser.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Don, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Don, Integer> event) {
                Don d = event.getRowValue();
                d.setId_user(event.getNewValue());
                DonService ds = new DonService();
                ds.modifier(d);
            }
        });
        
        
                    
        
        
        tableDon.setItems(data);
        
        try {
            searchDon();
        } catch (SQLException ex) {
            Logger.getLogger(ListDonController.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    
    
    
    @FXML
    private void supprimerDon(ActionEvent event) throws SQLException {
        DonService ds = new DonService();
        
        if (tableDon.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez sélectionner le don à supprimer");
            alert.showAndWait();
            return;
        }

        // Afficher une boîte de dialogue de confirmation
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vraiment supprimer ce don ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Récupérer l'ID de le Don sélectionnée dans la vue de la table
            int id = tableDon.getSelectionModel().getSelectedItem().getId_dons();

            // Supprimer le don de la base de données
            ds.supprimer(id);
            // Rafraîchir la liste de données
            data.clear();
            AfficherDon();
            // Rafraîchir la vue de la table
            tableDon.refresh();
        }
    }
    
    
    
    @FXML
    private void checkDon(ActionEvent event) throws SQLException {
        DonService ds = new DonService();
        
        if (tableDon.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez sélectionner le don à vérifier.");
            alert.showAndWait();
            return;
        }

        // Afficher une boîte de dialogue de confirmation
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez-vous vérifier ce don ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            int idU = tableDon.getSelectionModel().getSelectedItem().getId_user();
            //System.out.println(idU);
            List<Don> listeDonUser=ds.findById(idU);
            int count=listeDonUser.size();
            if(count>5){
                Alert alertP = new Alert(Alert.AlertType.CONFIRMATION);
                alertP.setTitle("Bande d'achat ");
                alertP.setHeaderText("Bande d achat.");
                alertP.showAndWait();
            }else{
                Alert alertP = new Alert(Alert.AlertType.ERROR);
                alertP.setTitle("Bande d'achat ");
                alertP.setHeaderText("Pas de bande d achat.");
                alertP.showAndWait();
            }
        }
    }
    
    
    
    public DonService ds = new DonService();
    
    public void searchDon() throws SQLException {    
        FilteredList<Don> filteredData = new FilteredList<>(FXCollections.observableArrayList(ds.Afficher()), p -> true);
        txtSearchDon.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(donn -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String type = String.valueOf(donn.getType_dons());
                String description = String.valueOf(donn.getDescription_dons());
                String lowerCaseFilter = newValue.toLowerCase();

                if (type.toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (description.toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<Don> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableDon.comparatorProperty());
        tableDon.setItems(sortedData);
    }
    
    
    

    
}



