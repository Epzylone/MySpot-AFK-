/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author ASUS
 */
import DataStorage.MyDB;
import IServices.IPreferencePropriete;
import entities.Preference;
import entities.Propriete;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PreferenceProprieteService implements IPreferencePropriete {
    Connection connexion;
    public PreferenceProprieteService() {
        connexion = MyDB.getinstance().getConnexion();
    }

    @Override
    public void affecterPreference(Propriete p, String nomPreference) {
        try {
            Preference pf= new PreferenceService().chercherPreferenceParNom(nomPreference);
            String query = "INSERT INTO preferencepropriete(idPropriete, idPreference) "
                    + "values ('"+p.getIdPropriete()+"','"+pf.getIdPreference()+"')";
            Statement stm= connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Affectation effectuée");
        } catch (SQLException ex) {
            System.out.println("Echec d'affectation");
        } 
    }

    @Override
    public void supprimerAffectation(Propriete p, String nomPreference) {
        try {
            Preference pf= new PreferenceService().chercherPreferenceParNom(nomPreference);
            String query = "DELETE FROM preferencepropriete "
                    + "where idPropriete='"+p.getIdPropriete()+"' AND idPreference='"+pf.getIdPreference()+"'";
            Statement stm= connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Affectation supprimée");
        } catch (SQLException ex) {
            System.out.println("Echec de suppression de l'affectation");
        }
    }

    @Override
    public boolean estAffectee(Propriete p, String nomPreference) {
         try {
            Preference pf= new PreferenceService().chercherPreferenceParNom(nomPreference);
            String query = "SELECT * FROM preferencepropriete "
                    + "where idPropriete='"+p.getIdPropriete()+"' AND idPreference='"+pf.getIdPreference()+"'";
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
