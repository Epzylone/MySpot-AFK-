/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import DataStorage.MyDB;
import IServices.IPreference;
import entities.Preference;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class PreferenceService implements IPreference {
    Connection connexion;
    public PreferenceService() {
        connexion = MyDB.getinstance().getConnexion();
    }


    @Override
    public void ajouterPreference(Preference p) {
        try {
            String query = "INSERT INTO preference (nomPreference) "
                    + "values ('"+p.getNomPreference()+"')";
            Statement stm= connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Ajout effectué");
        } catch (SQLException ex) {
            System.out.println("Echec d'ajout");
        } 
    }

    @Override
    public void supprimerPreference(Preference p) {
        try {
            String query = "DELETE FROM preference "
                    + "where nomPreference='"+p.getNomPreference()+"'";
            Statement stm= connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Suppression effectuée");
        } catch (SQLException ex) {
            System.out.println("Echec de suppression");
        }
    }

    @Override
    public void modifierPreference(Preference p, String nomPreference) {
        try {
            String query = "UPDATE preference "
                    + "set nomPreference='"+p.getNomPreference()+"'"
                    + " where nomPreference='"+nomPreference+"'";
            Statement stm= connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Modification effectuée");
        } catch (SQLException ex) {
            System.out.println("Echec de modification");
        }
    }

    @Override
    public Preference chercherPreferenceParNom(String nomPreference) {
        try {
            String query = "SELECT * FROM preference where nomPreference='"+ nomPreference +"'";
            Statement stm= connexion.createStatement();
            ResultSet rst=stm.executeQuery(query);
            rst.next();
            Preference p= new Preference(rst.getString("nomPreference"));
            p.setIdPreference(rst.getInt("idPreference"));
            return p;
            
        } catch (SQLException ex) {
            System.out.println("Echec d'extraction de la preference");
            return null;
        }
    }

    @Override
    public List<Preference> consulterPreference() {
         try {
            String query = "SELECT * FROM preference";
            Statement stm= connexion.createStatement();
            ResultSet rst=stm.executeQuery(query);
            ArrayList<Preference> L= new ArrayList<Preference>();
            while(rst.next())
            {
                Preference p= new Preference(rst.getString("nomPreference"));
                L.add(p);
            }
           return L ;
            
        } catch (SQLException ex) {
            System.out.println("Echec d'extraction de la liste des preferences");
            return null;
        }
    }
    
}
