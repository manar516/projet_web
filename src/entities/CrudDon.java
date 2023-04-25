/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface CrudDon<D> {
    
    public void ajouter(D d);
    public void modifier(D d);
    public void supprimer(int id) throws SQLException;
    public List<Don> Afficher();
}
