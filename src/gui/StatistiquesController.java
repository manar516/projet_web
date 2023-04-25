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
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import services.ChariteService;
import services.DonService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class StatistiquesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private LineChart<String, Integer> lineChartDon;
    
    @FXML
    private AnchorPane statistiquePane;
    
    @FXML
    void open_listCharite(ActionEvent event) throws IOException {
        Parent fxml= FXMLLoader.load(getClass().getResource("listCharite.fxml"));
        statistiquePane.getChildren().removeAll();
        statistiquePane.getChildren().setAll(fxml);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        statistique();
    }   
    
    
    
    public void statistique() {
        ChariteService cs = new ChariteService();
        DonService ds = new DonService();

        List<Charite> charities = null;
        charities = cs.Afficher();
        
        

        // Créer les axes pour le graphique
        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Nom Charite");
        yAxis.setLabel("Nombre des dons");

        // Créer la série de données à afficher
        XYChart.Series series = new XYChart.Series();
        series.setName("Statistiques de nombre des dons par charité");
        for (Charite ch : charities) {
            try {
                series.getData().add(new XYChart.Data<>(ch.getNom_charite(), ds.findChariteDon(ch.getId_charite()).size()));
            } catch (SQLException ex) {
                Logger.getLogger(StatistiquesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Créer le graphique et ajouter la série de données
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Statistiques de nombre des dons par charité");
        lineChart.getData().add(series);

        // Afficher le graphique dans votre scène
        lineChartDon.setCreateSymbols(false);
        lineChartDon.getData().add(series);
        
        


    }
    
}
