/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.CrudDon;
import entities.Don;
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
public class DonService implements CrudDon<Don>{

    public Connection conx;
    public Statement stm;

    
    public DonService() {
        conx = MyDB.getInstance().getConx();

    }
    
    @Override
    public void ajouter(Don d) {
        String req = 
                "INSERT INTO don"
                + "(id_user,id_charite,type_dons,description_dons)"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conx.prepareStatement(req);
            ps.setInt(1, d.getId_user());
            ps.setInt(2, d.getId_charite());
            ps.setString(3, d.getType_dons());
            ps.setString(4, d.getDescription_dons());
            ps.executeUpdate();
            System.out.println("Don Ajoutée !!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void modifier(Don d) {
        try {
            String req = "UPDATE don SET  id_user=?,id_charite=?, type_dons=?, description_dons=? WHERE id_dons=?";
            PreparedStatement pst = conx.prepareStatement(req);
            pst.setInt(5, d.getId_dons());
            pst.setInt(1, d.getId_user());
            pst.setInt(2, d.getId_charite());
            pst.setString(3, d.getType_dons());
            pst.setString(4, d.getDescription_dons());
            pst.executeUpdate();
            System.out.println("Don " + d.getType_dons()+ " Modifiée !");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM don WHERE id_dons=?";
        try {
            PreparedStatement pst = conx.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Don suprimée !");

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }
    }

    @Override
    public List<Don> Afficher() {
        List<Don> list = new ArrayList<>();

        try {
            String req = "SELECT * from don";
            Statement st = conx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(new Don(rs.getInt("id_dons"), rs.getInt("id_user"), 
                        rs.getInt("id_charite"), rs.getString("type_dons"), rs.getString("description_dons")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    
    public List<Don> findById(int id) throws SQLException {
        List<Don> list = new ArrayList<>();

        try {
            String req = "SELECT * from don where id_user='"+id+"'";
            Statement st = conx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(new Don(rs.getInt("id_dons"), rs.getInt("id_user"), 
                        rs.getInt("id_charite"), rs.getString("type_dons"), rs.getString("description_dons")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    public List<Integer> findChariteDon(int idch) throws SQLException {
        List<Integer> list = new ArrayList<>();

        try {
            String req = "SELECT id_dons from don where id_charite='"+idch+"'";
            Statement st = conx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(rs.getInt("id_dons"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }

    
    
}
