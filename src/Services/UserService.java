package Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
import DataStorage.MyDB;
import IServices.IUser;
import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService implements IUser {
    Connection connexion;
    public UserService() {
        connexion = MyDB.getinstance().getConnexion();
    }

    @Override
    public void ajouterUser(User u) {
        try {
            String query = "INSERT INTO user (userName, userNameCanonical, userNom, userPrenom, email, emailCanonical, enabled, password, lastLogin, confirmationToken, telUser, dateInscription, photoProfile, nombreConnexion, dateNaissance, descriptionUser) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm= connexion.prepareStatement(query);
            pstm.setString( 1, u.getUserName());
            pstm.setString( 2, u.getUserNameCanonical());
            pstm.setString( 3, u.getUserNom());
            pstm.setString( 4, u.getUserPrenom());
            pstm.setString( 5, u.getEmail());
            pstm.setString( 6, u.getEmailCanonical());
            pstm.setBoolean( 7, u.getEnabled());
            pstm.setString( 8, u.getPassword());
            java.sql.Date sqlDate1 = new java.sql.Date(u.getLastLogin().getTime());
            pstm.setDate( 9, sqlDate1);
            pstm.setString( 10, u.getConfirmationToken());
            pstm.setLong( 11, u.getTelUser());
            java.sql.Date sqlDate3 = new java.sql.Date(u.getDateInscription().getTime());
            pstm.setDate( 12, sqlDate3);
            pstm.setString( 13, u.getPhotoProfile());
            pstm.setLong( 14, u.getNombreConnexion());
            java.sql.Date sqlDate4 = new java.sql.Date(u.getDateNaissance().getTime());
            pstm.setDate( 15, sqlDate4);
            pstm.setString( 16, u.getDescriptionUser());
            pstm.executeUpdate();
            
            
            System.out.println("Ajout effectué");
        } catch (SQLException ex) {
            System.out.println("Echec d'ajout");
            
        }
    }

    @Override
    public void supprimerUser(User u) {
        try {
            String query = "DELETE FROM user "
                    + "where email='"+u.getEmail()+"'";
            Statement stm= connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Suppression effectuée");
        } catch (SQLException ex) {
            System.out.println("Echec de suppression");
        }
    }

    @Override
    public void modifierUser(User u, String email) {
        try {

            String query = "UPDATE user SET userName=?, userNameCanonical=?, userNom=?, userPrenom=?, email=?, emailCanonical=?, enabled=?, password=?, lastLogin=?, confirmationToken=?, telUser=?, dateInscription=?, photoProfile=?, nombreConnexion=?, dateNaissance=?, descriptionUser=?"  
                    + " where email=?";
            PreparedStatement pstm= connexion.prepareStatement(query);
            pstm.setString( 1, u.getUserName());
            pstm.setString( 2, u.getUserNameCanonical());
            pstm.setString( 3, u.getUserNom());
            pstm.setString( 4, u.getUserPrenom());
            pstm.setString( 5, u.getEmail());
            pstm.setString( 6, u.getEmailCanonical());
            pstm.setBoolean( 7, u.getEnabled());
            pstm.setString( 8, u.getPassword());
            java.sql.Date sqlDate1 = new java.sql.Date(u.getLastLogin().getTime());
            pstm.setDate( 9, sqlDate1);
            pstm.setString( 10, u.getConfirmationToken());
            pstm.setLong( 11, u.getTelUser());
            java.sql.Date sqlDate3 = new java.sql.Date(u.getDateInscription().getTime());
            pstm.setDate( 12, sqlDate3);
            pstm.setString( 13, u.getPhotoProfile());
            pstm.setLong( 14, u.getNombreConnexion());
            java.sql.Date sqlDate4 = new java.sql.Date(u.getDateNaissance().getTime());
            pstm.setDate( 15, sqlDate4);
            pstm.setString( 16, u.getDescriptionUser());
            pstm.setString( 17, email);
            pstm.executeUpdate();
            System.out.println("Modification effectuée");
        } catch (SQLException ex) {
            System.out.println("Echec de modification");
        }
    }

    @Override
    public List<User> lireUsers() {
        try {
            String query = "SELECT * FROM user";
            Statement stm= connexion.createStatement();
            ResultSet rst=stm.executeQuery(query);
            ArrayList<User> L= new ArrayList<User>();
            System.out.println("Liste des users:");
            while(rst.next())
            {
                User u= new User(rst.getString("userName"),rst.getString("userNom"),rst.getString("userPrenom"),rst.getString("email"),rst.getString("password"),rst.getLong("telUser"),rst.getString("photoProfile"),rst.getDate("dateNaissance"),rst.getString("descriptionUser"));
                L.add(u);
            }
           return L ;
            
        } catch (SQLException ex) {
            System.out.println("Echec d'extraction de la liste des personnes");
            return null;
        }
    }

    @Override
    public User chercherUserParEmail(String email) {
       try {
            String query = "SELECT * FROM user where email='"+ email +"'";
            Statement stm= connexion.createStatement();
            ResultSet rst=stm.executeQuery(query);
            rst.next();
            User u= new User(rst.getString("userName"),rst.getString("userNom"),rst.getString("userPrenom"),rst.getString("email"),rst.getString("password"),rst.getLong("telUser"),rst.getString("photoProfile"),rst.getDate("dateNaissance"),rst.getString("descriptionUser"));
            u.setIdUser(rst.getInt("idUser"));
            return u;
            
        } catch (SQLException ex) {
            System.out.println("Echec d'extraction de la personne");
            return null;
        }
    }
    
    
    
}
