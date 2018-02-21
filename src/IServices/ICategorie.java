/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;
import entities.Categorie;
import java.util.List;
import javafx.collections.ObservableList;
/**
 *
 * @author Fares
 */
public interface ICategorie {

    /**
     *
     * @param id
     * @return
     */
    public Categorie FindCategorieById(int id);
    public Categorie FindCategorieByNom(String nom);
    public ObservableList<Categorie> getAllCategorie();
    public void AjouterCategorie(Categorie C);
    public void SupprimerCategorie (String nom);
    public void ModifierCategorie (String nomCat,String nomNewCat);
}
