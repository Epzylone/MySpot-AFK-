/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import entities.Preference;
import entities.User;
import javafx.scene.control.ListCellBuilder;
/**
 *
 * @author ASUS
 */
public interface IPreferenceUser {
    public void affecterPreference(User u, String nomPreference);

    public void supprimerAffectation(User u, String nomPreference);
    
    public boolean estAffectee(User u,String nomPreference);
}
