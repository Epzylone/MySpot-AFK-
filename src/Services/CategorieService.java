/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import DataStorage.MyDB;
import IServices.ICategorie;
import entities.Categorie;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Fares
 */
public class CategorieService implements ICategorie {
    
    Connection connexion;
    
    public CategorieService(){
        connexion = MyDB.getinstance().getConnexion();
    }
    
    /**
     *
     * @param id
     * @return
     */
    @Override
    public Categorie FindCategorieById(int id){
        try{
        String query = "SELECT * FROM categorie WHERE idCategorie= ? ";
        PreparedStatement PSTMT = connexion.prepareStatement(query);
        PSTMT.setInt(1,id);
        ResultSet RS = PSTMT.executeQuery();
        RS.next();
        Categorie cat = new Categorie(id,RS.getString("nomCategorie"));
        System.out.println("Réussite, FIND CATEGORIE");
        return cat;
        }catch(SQLException ex){
            System.out.println("Echec FIND BY ID!!!!");
            return null;
        }
        
    }
    @Override
     public Categorie FindCategorieByNom(String Nom){
        try{
        String query = "SELECT * FROM categorie WHERE nomCategorie= ? ";
        PreparedStatement PSTMT = connexion.prepareStatement(query);
        PSTMT.setString(1,Nom);
        ResultSet RS = PSTMT.executeQuery();
        RS.next();
        Categorie cat = new Categorie(RS.getInt("idCategorie"),RS.getString("nomCategorie"));
        System.out.println("Réussite, FIND CATEGORIE");
        return cat;
        }catch(SQLException ex){
            Categorie cat = new Categorie();
            System.out.println("Echec FIND BY NOM!");
            return cat;
        }
        
    }

    @Override
    public ObservableList<Categorie> getAllCategorie() {
         try {
            ObservableList<Categorie> cat= FXCollections.observableArrayList();
            String query = "SELECT * FROM categorie";
            Statement stm = connexion.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next())
            {
               Categorie categorie=new Categorie(rs.getInt("idCategorie"), rs.getString("nomCategorie"));
               cat.add(categorie);
            }
            return cat;
        } catch(SQLException ex){
            System.out.println("Echec !!!");
            return null;
        }
    }

    @Override
    public void AjouterCategorie(Categorie C) {
         try{
        String query = "INSERT INTO categorie (nomCategorie)"
                + " VALUES (?)";
        PreparedStatement PSTMT = connexion.prepareStatement(query);
        PSTMT.setString(1,C.getNomCategorie());
        PSTMT.executeUpdate();
        System.out.println("Réussite, catégorie ajouter !");
        }catch(SQLException ex){
            System.out.println("Echec !!!!!!!!!!!!!");
        }
    }

    @Override
    public void SupprimerCategorie(String nom) {
         try{
        String query = "DELETE FROM categorie "
                + " WHERE nomCategorie=?";
             System.out.println(nom);
        PreparedStatement PSTMT = connexion.prepareStatement(query);
        PSTMT.setString(1,nom);
        PSTMT.executeUpdate();
        System.out.println("Réussite, catégorie supprimer");
        }catch(SQLException ex){
            System.out.println("Echec !!!");
        }
    }

    @Override
    public void ModifierCategorie(String nomCat, String nomNewCat) {
       try{
        String query = "UPDATE categorie set nomCategorie=?"
                + " WHERE nomCategorie=?";
        PreparedStatement PSTMT = connexion.prepareStatement(query);
        PSTMT.setString(1,nomNewCat);
        PSTMT.setString(2, nomCat);
        PSTMT.executeUpdate();
        System.out.println("Réussite, catégorie MODIFIER !");
        }catch(SQLException ex){
            System.out.println("Echec !!!");
        }
    }
    
    
    
}
