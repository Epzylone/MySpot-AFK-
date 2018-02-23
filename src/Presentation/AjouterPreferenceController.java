/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.PreferenceService;
import entities.Preference;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterPreferenceController implements Initializable {

    @FXML
    private TextField tfnomPreference;
    @FXML
    private Button ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterPreferenceAction(MouseEvent event) {
        PreferenceService ps=new PreferenceService();
        Preference p=new Preference(tfnomPreference.getText());
        ps.ajouterPreference(p);
        tfnomPreference.setText("");
    }
    
}
