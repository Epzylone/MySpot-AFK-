/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import entities.Preference;
import java.util.List;
import javafx.scene.control.ListCellBuilder;
/**
 *
 * @author ASUS
 */
public interface IPreference {
    public void ajouterPreference(Preference p);

    public void supprimerPreference(Preference p);
    
    public void modifierPreference(Preference p, String nomPreference);
    
    public Preference chercherPreferenceParNom(String nomPreference);
    
    public List<Preference> consulterPreference();
}
