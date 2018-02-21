/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;
import entities.Propriete;
import java.util.List;
import javafx.scene.control.ListCellBuilder;


/**
 *
 * @author Fares
 */
public interface IPropriete {
     public void ajouterPropriete(Propriete p);
     public void supprimerPropriete(Propriete p);
     public void modifierPropriete(Propriete p, int id);
     public Propriete chercherPropriete(String nom);
     public Propriete getProprieteByTel(long tel);
     public Propriete getProprieteByUserId(int id);
     public List<Propriete> lirePropriete();
}
