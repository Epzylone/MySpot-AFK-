/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IPhotoPropriete;
import entities.PhotoPropriete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Fares
 */
public class PhotoProprieteService implements IPhotoPropriete {
Connection connexion;

    public PhotoProprieteService() {
        connexion = MyDB.getinstance().getConnexion();
    }

    public void ajouterPhotoPropriete(PhotoPropriete P) {
        try {
     
            String query = "INSERT INTO photopropriete (URLphoto, idPropriete) "
                    + "values (?,?)";
            PreparedStatement pstmt = connexion.prepareStatement(query);
            pstmt.setString( 1, P.getURLphoto());
            pstmt.setInt( 2, P.getIdPropriete());
            pstmt.executeUpdate();
            System.out.println("Ajout de l'image effectué");
        } catch (SQLException ex) {
            System.out.println("Echec d'ajout image");
        }
    }
    
}
