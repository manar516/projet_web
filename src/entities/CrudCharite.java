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
public interface CrudCharite<Char> {
    public void ajouter(Char c);
    public void modifier(Char c);
    public void supprimer(int id) throws SQLException;
    public List<Charite> Afficher();
}
