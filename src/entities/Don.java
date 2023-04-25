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
public class Don {
    private int id_dons;
    private int id_user;
    private int id_charite;
    private String type_dons;
    private String description_dons;

    public Don() {
    }

    public Don(int id_charite, String type_dons, String description_dons) {
        this.id_charite = id_charite;
        this.type_dons = type_dons;
        this.description_dons = description_dons;
    }

    public Don(int id_dons, int id_user, int id_charite, String type_dons, String description_dons) {
        this.id_dons = id_dons;
        this.id_user = id_user;
        this.id_charite = id_charite;
        
        this.type_dons = type_dons;
        this.description_dons = description_dons;
    }

    public Don(int id_charite, int id_user, String type_dons, String description_dons) {
        this.id_charite = id_charite;
        this.id_user = id_user;
        this.type_dons = type_dons;
        this.description_dons = description_dons;
    }

    public Don(String type_dons, String description_dons) {
        this.type_dons = type_dons;
        this.description_dons = description_dons;
    }

    public int getId_dons() {
        return id_dons;
    }

    public void setId_dons(int id_dons) {
        this.id_dons = id_dons;
    }

    public int getId_charite() {
        return id_charite;
    }

    public void setId_charite(int id_charite) {
        this.id_charite = id_charite;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getType_dons() {
        return type_dons;
    }

    public void setType_dons(String type_dons) {
        this.type_dons = type_dons;
    }

    public String getDescription_dons() {
        return description_dons;
    }

    public void setDescription_dons(String description_dons) {
        this.description_dons = description_dons;
    }
    
    
}
