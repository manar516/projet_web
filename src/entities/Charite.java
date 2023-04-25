/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ASUS
 */
public class Charite {
    private int id_charite;
    private String nom_charite;
    private String lieu_charite;
    private String type_charite;

    public Charite() {
    }

    public Charite(int id_charite, String nom_charite, String lieu_charite, String type_charite) {
        this.id_charite = id_charite;
        this.nom_charite = nom_charite;
        this.lieu_charite = lieu_charite;
        this.type_charite = type_charite;
    }

    public Charite(String nom_charite, String lieu_charite, String type_charite) {
        this.nom_charite = nom_charite;
        this.lieu_charite = lieu_charite;
        this.type_charite = type_charite;
    }

    public int getId_charite() {
        return id_charite;
    }

    public void setId_charite(int id_charite) {
        this.id_charite = id_charite;
    }

    public String getNom_charite() {
        return nom_charite;
    }

    public void setNom_charite(String nom_charite) {
        this.nom_charite = nom_charite;
    }

    public String getLieu_charite() {
        return lieu_charite;
    }

    public void setLieu_charite(String lieu_charite) {
        this.lieu_charite = lieu_charite;
    }

    public String getType_charite() {
        return type_charite;
    }

    public void setType_charite(String type_charite) {
        this.type_charite = type_charite;
    }
    
    
}
