/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IPreferenceUser;
import entities.Preference;
import entities.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class PreferenceUserService implements IPreferenceUser {
    Connection connexion;
    public PreferenceUserService() {
        connexion = MyDB.getinstance().getConnexion();
    }

    @Override
    public void affecterPreference(User u, String nomPreference) {
        try {
            
            Preference p= new PreferenceService().chercherPreferenceParNom(nomPreference);
            String query = "INSERT INTO preferenceuser (idUser, idPreference) "
                    + "values ('"+u.getIdUser()+"','"+p.getIdPreference()+"')";
            Statement stm= connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Affectation effectuée");
        } catch (SQLException ex) {
            System.out.println("Echec d'affectation");
        } 
    }

    @Override
    public void supprimerAffectation(User u, String nomPreference) {
        try {
            Preference p= new PreferenceService().chercherPreferenceParNom(nomPreference);
            String query = "DELETE FROM preferenceuser "
                    + "where idUser='"+u.getIdUser()+"' AND idPreference='"+p.getIdPreference()+"'";
            Statement stm= connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Affectation supprimée");
        } catch (SQLException ex) {
            System.out.println("Echec de suppression de l'affectation");
        }
    }

    @Override
    public boolean estAffectee(User u, String nomPreference) {
        try {
            Preference p= new PreferenceService().chercherPreferenceParNom(nomPreference);
            String query = "SELECT * FROM preferenceuser "
                    + "where idUser='"+u.getIdUser()+"' AND idPreference='"+p.getIdPreference()+"'";
            Statement stm= connexion.createStatement();
            ResultSet rst=stm.executeQuery(query);
            if(rst.next())
            {return true;
            }
            else {return false;}
        } catch (SQLException ex) {
            return false;
        }
    }
    
    
}
