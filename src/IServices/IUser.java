/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import entities.User;
import java.util.List;
import javafx.scene.control.ListCellBuilder;
/**
 *
 * @author ASUS
 */
public interface IUser {
    
    public void ajouterUser(User u);

    public void supprimerUser(User u);
    
    public void modifierUser(User u, String email);
    
    public User chercherUserParEmail(String email);
    
    public List<User> lireUsers();
}
