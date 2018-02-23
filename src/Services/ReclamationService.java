/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.IReclamation;
import entities.EtatReclamation;
import entities.Reclamation;
import entities.TypeReclamation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS
 */
public class ReclamationService implements IReclamation{
    Connection connexion;
    public ReclamationService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
    @Override
    public void ajouterReclamation(Reclamation r) {
        try {
            java.sql.Date sqlDate = new java.sql.Date(r.getDateReclamation().getTime());
            String query = "INSERT INTO reclamation (etatReclamation,dateReclamation,typeReclamation,idSignalement) "
                    + "values ('"+r.getEtatReclamation()+"','"+sqlDate+"','"+r.getTypeReclamation()+"','"+r.getIdSignalement()+"')";
            Statement stm= connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Ajout effectué");
        } catch (SQLException ex) {
            System.out.println("Echec d'ajout");
        } 
    }

    @Override
    public List<Reclamation> consulterReclamation() {
        try {
            String query = "SELECT * FROM reclamation";
            Statement stm= connexion.createStatement();
            ResultSet rst=stm.executeQuery(query);
            ArrayList<Reclamation> L= new ArrayList<Reclamation>();
            while(rst.next())
            {
              Reclamation r = null;
               switch(rst.getString("etatReclamation"))
                {
                    case "enAttente": switch(rst.getString("typeReclamation")){
                        case "commentaire": r = new Reclamation(EtatReclamation.enAttente,rst.getDate("dateReclamation"),TypeReclamation.commentaire,rst.getInt("idSignalement"));break;
                        case "promotion": r = new Reclamation(EtatReclamation.enAttente,rst.getDate("dateReclamation"),TypeReclamation.promotion,rst.getInt("idSignalement"));break;
            
                    }
                    break;
                    case "traitee": switch(rst.getString("typeReclamation")){
                        case "commentaire": r = new Reclamation(EtatReclamation.traitee,rst.getDate("dateReclamation"),TypeReclamation.commentaire,rst.getInt("idSignalement"));break;
                        case "promotion":  r = new Reclamation(EtatReclamation.traitee,rst.getDate("dateReclamation"),TypeReclamation.promotion,rst.getInt("idSignalement"));break;
                    }
                    break;
                }
            
                L.add(r);
            }
           return L ;
            
        } catch (SQLException ex) {
            System.out.println("Echec d'extraction de la liste des personnes");
            return null;
        }
    }

    @Override
    public void traiterReclamation(Reclamation r) {
        if(r.getTypeReclamation()==TypeReclamation.commentaire)
        {
            CommentaireService cs= new CommentaireService();
            cs.supprimerCommentaire(r.getIdSignalement());
            try{
            String query = "UPDATE reclamation set etatReclamation='"+EtatReclamation.traitee+"'"
                    + " where etatReclamation='"+r.getEtatReclamation()+"' AND dateReclamation='"+r.getDateReclamation()+"' AND typeReclamation='"+r.getTypeReclamation()+"' AND idSignalement='"+r.getIdSignalement()+"'";
            Statement stm= connexion.createStatement();
            stm.executeUpdate(query);
            }
            catch (SQLException ex) {
            System.out.println("Echec de mise à jour");
            } 
        }
        else if(r.getTypeReclamation()==TypeReclamation.promotion)
        {
            PromotionService cs= new PromotionService();
            cs.supprimerPromotion(r.getIdSignalement());
            try{
            String query = "UPDATE reclamation set etatReclamation='"+EtatReclamation.traitee+"'"
                    + " where etatReclamation='"+r.getEtatReclamation()+"' AND dateReclamation='"+r.getDateReclamation()+"' AND typeReclamation='"+r.getTypeReclamation()+"' AND idSignalement='"+r.getIdSignalement()+"'";
            Statement stm= connexion.createStatement();
            stm.executeUpdate(query);
            }catch (SQLException ex) {
            System.out.println("Echec de mise à jour");
        } 
        }
    }
    
}
