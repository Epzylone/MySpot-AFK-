
package Services;
import DataStorage.MyDB;
import IServices.IPropriete;
import entities.Categorie;
import entities.Propriete;
import entities.TypePropriete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Services.CategorieService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author bhk
 */
public class ProprieteService implements IPropriete{
    Connection connexion;
    public ProprieteService() {
        connexion = MyDB.getinstance().getConnexion();
    }

    
    public void ajouterPropriete(Propriete p) {
        try {
     
            String query = "INSERT INTO propriete ( nomPropriete, adressePropriete, telPropriete, ville, latitude, longitude, jourOuverture, notePropriete, Description, fourchetteDePrix, dateAjout, livraison, idCategorie, idUser ) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = connexion.prepareStatement(query);
            pstmt.setString( 1, p.getNomPropriete());
            pstmt.setString( 2, p.getAdressePropriete());
            pstmt.setLong( 3, p.getTelPropriete());
            pstmt.setString( 4, p.getVille());
            pstmt.setDouble( 5, p.getLatitude());
            pstmt.setDouble( 6, p.getLongitude());
            pstmt.setString( 7, p.getJourOuverture());
            pstmt.setDouble( 8, p.getNotePropriete());
            pstmt.setString( 9, p.getDescription());
            pstmt.setInt( 10, p.getFourchetteDePrix());
            java.sql.Date sqlDate = new java.sql.Date( p.getDateAjout().getTime() );
            pstmt.setDate( 11, sqlDate );
            pstmt.setBoolean( 12, p.isLivraison() );
            pstmt.setInt( 13, p.getCategorie().getIdCategorie());
             pstmt.setInt( 14, 1);// USER STATIC !!!
            System.out.println(sqlDate);
            pstmt.executeUpdate();
            System.out.println("Ajout effectué");
        } catch (SQLException ex) {
            System.out.println("Echec d'ajout");
        }
    }
    
    
    public void supprimerPropriete(Propriete p) {
        try {
            String query = "DELETE FROM propriete " 
                    + "WHERE nomPropriete='"+p.getNomPropriete()+"'";
            Statement stm = connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Suppression Effectué!!!");
        } catch(SQLException ex){
            System.out.println("Echec de Suppression!!!");
        }
    }

    public void modifierPropriete(Propriete p, int id) {
        try {
            String query = "UPDATE propriete SET nomPropriete=?, adressePropriete=?, telPropriete=?,ville=?, latitude=?, longitude=?,jourOuverture=?,Description=?,fourchetteDePrix=?,livraison=?,idCategorie=? "  
                    + " where idPropriete=?";
            PreparedStatement pstmt = connexion.prepareStatement(query);
            pstmt.setString( 1, p.getNomPropriete());
            pstmt.setString( 2, p.getAdressePropriete());
            pstmt.setLong( 3, p.getTelPropriete());
            pstmt.setString( 4, p.getVille());
            pstmt.setDouble( 5, p.getLatitude());
            pstmt.setDouble( 6, p.getLongitude());
            pstmt.setString( 7, p.getJourOuverture());
            pstmt.setString( 8, p.getDescription());
            pstmt.setInt( 9, p.getFourchetteDePrix());
            pstmt.setBoolean( 10, p.isLivraison());
            pstmt.setInt( 11, p.getCategorie().getIdCategorie());
            pstmt.setInt( 12, id);
            pstmt.executeUpdate();
            System.out.println("Modification Effectué!!!");
        } catch(SQLException ex){
            System.out.println("Echec de Modification!!!");
        }
    }

    public Propriete chercherPropriete(String nom) {
       try {
          
           // ArrayList<Propriete> prop= new ArrayList<Propriete>();
            String query = "SELECT * FROM propriete "
                    +"WHERE nomPropriete='"+nom+"'";  
            Statement stm = connexion.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            CategorieService CS = new CategorieService();
            Propriete propriete=new Propriete(rs.getString("nomPropriete"), rs.getString("adressePropriete"), rs.getLong("telPropriete"), rs.getString("ville"), rs.getDouble("latitude"), rs.getDouble("longitude"),rs.getString("jourOuverture"),rs.getInt("notePropriete"),rs.getString("Description"),rs.getInt("fourchetteDePrix"),rs.getDate("dateAjout"),rs.getBoolean("livraison"),CS.FindCategorieById(rs.getInt("idCategorie")));
            return propriete;
            }
            catch(SQLException ex){
            System.out.println("Echec !!!");
            return null;
        }
    }

    @Override
    public ObservableList<Propriete> lirePropriete() {
         
        try {
           ObservableList<Propriete> prop= FXCollections.observableArrayList();
            String query = "SELECT * FROM propriete";
            Statement stm = connexion.createStatement();
            ResultSet rs = stm.executeQuery(query);
            CategorieService CS = new CategorieService();
            
            while(rs.next())
            {
              //Propriete propriete=new Propriete(rs.getString("nomPropriete"),rs.getInt("fourchetteDePrix"),rs.getBoolean("livraison"));
              Propriete propriete=new Propriete(rs.getString("nomPropriete"), rs.getString("adressePropriete"), rs.getLong("telPropriete"), rs.getString("ville"), rs.getDouble("latitude"), rs.getDouble("longitude"),rs.getString("jourOuverture"),rs.getInt("notePropriete"),rs.getString("Description"),rs.getInt("fourchetteDePrix"),rs.getDate("dateAjout"),rs.getBoolean("livraison"),CS.FindCategorieById(rs.getInt("idCategorie")));
              
              prop.add(propriete);
            }
            return prop;
        } catch(SQLException ex){
            System.out.println("Echec !!!");
            return null;
        }
    }
    

    @Override
    public Propriete getProprieteByTel(long tel) {
       try {
          
           
            String query = "SELECT * FROM propriete "
                    +"WHERE telPropriete='"+tel+"'";  
            Statement stm = connexion.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            CategorieService CS = new CategorieService();
            Propriete propriete=new Propriete(rs.getInt("idPropriete"),rs.getString("nomPropriete"), rs.getString("adressePropriete"), rs.getLong("telPropriete"), rs.getString("ville"), rs.getDouble("latitude"), rs.getDouble("longitude"),rs.getString("jourOuverture"),rs.getInt("notePropriete"),rs.getString("Description"),rs.getInt("fourchetteDePrix"),rs.getDate("dateAjout"),rs.getBoolean("livraison"),CS.FindCategorieById(rs.getInt("idCategorie")));
           
            return propriete;
            }
            catch(SQLException ex){
            System.out.println("Echec !!!");
            return null;
        }
    }

 public Propriete getProprieteByUserId(int id) {
       try {
          
           
            String query = "SELECT * FROM propriete "
                    +"WHERE idUser='"+id+"'";  
            Statement stm = connexion.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            CategorieService CS = new CategorieService();
            Propriete propriete=new Propriete(rs.getInt("idPropriete"),rs.getString("nomPropriete"), rs.getString("adressePropriete"), rs.getLong("telPropriete"), rs.getString("ville"), rs.getDouble("latitude"), rs.getDouble("longitude"),rs.getString("jourOuverture"),rs.getInt("notePropriete"),rs.getString("Description"),rs.getInt("fourchetteDePrix"),rs.getDate("dateAjout"),rs.getBoolean("livraison"),CS.FindCategorieById(rs.getInt("idCategorie")));
            
            return propriete;
            }
            catch(SQLException ex){
            System.out.println("Echec !!!");
            return null;
        }
    }
}