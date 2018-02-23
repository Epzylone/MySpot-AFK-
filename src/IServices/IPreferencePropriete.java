/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import entities.Preference;
import entities.Propriete;
import javafx.scene.control.ListCellBuilder;
/**
 *
 * @author ASUS
 */
public interface IPreferencePropriete {
     public void affecterPreference(Propriete p, String nomPreference);

    public void supprimerAffectation(Propriete p, String nomPreference);
    
    public boolean estAffectee(Propriete p,String nomPreference);
}
