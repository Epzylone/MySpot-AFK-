/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import DataStorage.MyDB;
import IServices.ICritereEvaluation;
import entities.CritereEvaluation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Fares
 */
public class CritereEvaluationService implements ICritereEvaluation {
        Connection  connexion;
    public CritereEvaluationService() {
        connexion = MyDB.getinstance().getConnexion();
    }

    @Override
    public void ajouterCritereEvaluation(CritereEvaluation c) {
        try {
            String query = "INSERT INTO critereevaluation (nomCritere) "
                    + "values (?)";
            PreparedStatement pstmt = connexion.prepareStatement(query);
            pstmt.setString( 1, c.getNomCritere());
            pstmt.executeUpdate();
            System.out.println("Ajout effectué");
        } catch (SQLException ex) {
            System.out.println("Echec d'ajout");
        }
    }

    @Override
    public void supprimerCritereEvaluation(String nomCritere) {
         try {
            String query = "DELETE FROM critereevaluation " 
                    + "WHERE nomCritere='"+nomCritere+"'";
            Statement stm = connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Suppression Effectué!!!");
        } catch(SQLException ex){
            System.out.println("Echec de Suppression!!!");
        }
    }

    @Override
    public void modifierCritereEvaluation(CritereEvaluation c, String Nom) {
         try {
            String query = "UPDATE critereevaluation set nomCritere=? "
                    + "WHERE nomCritere=?";
            PreparedStatement pstmt = connexion.prepareStatement(query);
            pstmt.setString( 1, c.getNomCritere());
            pstmt.setString( 2, Nom);
            pstmt.executeUpdate();
            System.out.println("MODIF effectué");
        } catch (SQLException ex) {
            System.out.println("Echec de MODIF");
        }
    }
    
    
    @Override
    public ObservableList<CritereEvaluation> getallCritere(int id) {
         try {
            ObservableList<CritereEvaluation> crit= FXCollections.observableArrayList();
            String query = "SELECT * FROM categoriecritere WHERE idCategorie='"+id+"'";
            Statement stm = connexion.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next())
            {
              //Propriete propriete=new Propriete(rs.getString("nomPropriete"),rs.getInt("fourchetteDePrix"),rs.getBoolean("livraison"));
              CritereEvaluation critere=new CritereEvaluation(rs.getInt("idCritere"),getcritere(rs.getInt("idCritere")).getNomCritere());  
              crit.add(critere);
            }
            return crit;
        } catch(SQLException ex){
            System.out.println("Echec get all critere!!!");
            return null;
        }
    }

    @Override
    public CritereEvaluation getcritere(int id) {
        try {
            String query = "SELECT * FROM critereevaluation WHERE idCritere='"+id+"'";
            Statement stm = connexion.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            CritereEvaluation critere=new CritereEvaluation(rs.getInt("idCritere"),rs.getString("nomCritere"));
            return critere;
        } catch(SQLException ex){
            System.out.println("Echec get critere!!!");
            return null;
        }
    }

    @Override
    public CritereEvaluation getcriterebynom(String nom) {
       try {
            String query = "SELECT * FROM critereevaluation WHERE nomCritere='"+nom+"'";
            Statement stm = connexion.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            CritereEvaluation critere=new CritereEvaluation(rs.getInt("idCritere"),rs.getString("nomCritere"));
            return critere;
        } catch(SQLException ex){
            System.out.println("Echec get critere!!!");
            return null;
        }
    }
    
}
