/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.ICategorieCritere;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Fares
 */
public class CategorieCritereService implements ICategorieCritere {
    Connection connexion;
    
    public CategorieCritereService(){
        connexion = MyDB.getinstance().getConnexion();
    }
    @Override
    public void AffecterCategorieCritere(int idCategorie, int idCritere) {
          try{
        String query = "INSERT INTO categoriecritere (idCategorie, idCritere)"
                + " VALUES (?,?)";
        PreparedStatement PSTMT = connexion.prepareStatement(query);
        PSTMT.setInt(1,idCategorie);
        PSTMT.setInt(2,idCritere);
        PSTMT.executeUpdate();
        System.out.println("Réussite, catégorieCRITERE ajouter !");
        }catch(SQLException ex){
            System.out.println("Echec !!!!!!!!!!!!!");
        }
    }
    
}
