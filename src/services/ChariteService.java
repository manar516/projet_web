/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Charite;
import entities.CrudCharite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author ASUS
 */
public class ChariteService implements CrudCharite<Charite>{

    public Connection conx;
    public Statement stm;

    
    public ChariteService() {
        conx = MyDB.getInstance().getConx();

    }
    
    @Override
    public void ajouter(Charite c) {
        String req = 
                "INSERT INTO charite"
                + "(nom_charite,lieu_charite,type_charite)"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement ps = conx.prepareStatement(req);
            ps.setString(1, c.getNom_charite());
            ps.setString(2, c.getLieu_charite());
            ps.setString(3, c.getType_charite());
            ps.executeUpdate();
            System.out.println("Charité Ajoutée !!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void modifier(Charite c) {
        try {
            String req = "UPDATE charite SET nom_charite=?, lieu_charite=?, type_charite=? WHERE id_charite=?";
            PreparedStatement pst = conx.prepareStatement(req);
            pst.setInt(4, c.getId_charite());
            pst.setString(1, c.getNom_charite());
            pst.setString(2, c.getLieu_charite());
            pst.setString(3, c.getType_charite());
            pst.executeUpdate();
            System.out.println("Charité " + c.getNom_charite() + " Modifiée !");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM charite WHERE id_charite=?";
        try {
            PreparedStatement pst = conx.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Charité suprimée !");

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }
    }

    @Override
    public List<Charite> Afficher() {
        List<Charite> list = new ArrayList<>();

        try {
            String req = "SELECT * from charite";
            Statement st = conx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(new Charite(rs.getInt("id_charite"), rs.getString("nom_charite"), 
                        rs.getString("lieu_charite"), rs.getString("type_charite")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    
}
