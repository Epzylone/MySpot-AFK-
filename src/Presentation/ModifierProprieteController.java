/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.CategorieService;
import Services.ProprieteService;
import entities.Propriete;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Fares
 */
public class ModifierProprieteController implements Initializable {

    @FXML
    private Button modifier;
    @FXML
    private TextField nomPropriete;
    @FXML
    private TextField adressePropriete;
    @FXML
    private TextField telephonePropriete;
    @FXML
    private CheckBox dimanche;
    @FXML
    private CheckBox lundi;
    @FXML
    private CheckBox mardi;
    @FXML
    private CheckBox mercredi;
    @FXML
    private CheckBox jeudi;
    @FXML
    private CheckBox vendredi;
    @FXML
    private CheckBox samedi;
    @FXML
    private RadioButton prix1;
    @FXML
    private RadioButton prix2;
    @FXML
    private RadioButton prix3;
    @FXML
    private RadioButton prix4;
    @FXML
    private ComboBox typePropriete;
    @FXML
    private RadioButton livraisonOui;
    @FXML
    private RadioButton livraisonNon;
    @FXML
    private TextArea descriptionPropriete;
    
    
    CategorieService CS = new CategorieService();
    Propriete P = new Propriete();
    ProprieteService PS = new ProprieteService();
    /**
     * 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        P=PS.getProprieteByUserId(1);
        nomPropriete.setText(P.getNomPropriete());
        adressePropriete.setText(P.getAdressePropriete());
        telephonePropriete.setText(String.valueOf(P.getTelPropriete()));
        if (P.isLivraison())
            livraisonOui.setSelected(true);
        else 
            livraisonNon.setSelected(true);
        String JO = P.getJourOuverture();
        boolean find = false;
        if (JO.lastIndexOf("dimanche") != -1)
            dimanche.setSelected(true);
        if (JO.lastIndexOf("lundi") != -1)
            lundi.setSelected(true);
        if (JO.lastIndexOf("mardi") != -1)
            mardi.setSelected(true);
        if (JO.lastIndexOf("mercredi") != -1)
            mercredi.setSelected(true);
        if (JO.lastIndexOf("jeudi") != -1)
            jeudi.setSelected(true);
        if (JO.lastIndexOf("vendredi") != -1)
            vendredi.setSelected(true);
        if (JO.lastIndexOf("samedi") != -1)
            samedi.setSelected(true);
        switch(P.getFourchetteDePrix()){
            case 1: prix1.setSelected(true);
            case 2: prix2.setSelected(true);
            case 3: prix3.setSelected(true);
            case 4: prix4.setSelected(true);
        }
        
        //System.out.println(CS.getAllCategorie().size());
        //typePropriete.getItems().setAll(CS.getAllCategorie());
        typePropriete.getItems().setAll(CS.getAllCategorie());
        typePropriete.setValue(P.getCategorie());
        descriptionPropriete.setText(P.getDescription());
    }    

    @FXML
    private void modifAction(ActionEvent event) {
        P.setNomPropriete(nomPropriete.getText());
        P.setAdressePropriete(adressePropriete.getText());
        String jourouverture="";
        if(dimanche.isSelected())
        jourouverture=jourouverture+" dimanche";
        if(lundi.isSelected())
        jourouverture=jourouverture+" lundi";
        if(mardi.isSelected())
        jourouverture=jourouverture+" mardi";
        if(mercredi.isSelected())
        jourouverture=jourouverture+" mercredi";
        if(jeudi.isSelected())
        jourouverture=jourouverture+" jeudi";
        if(vendredi.isSelected())
        jourouverture=jourouverture+" vendredi";
        if(samedi.isSelected())
        jourouverture=jourouverture+" samedi";
        P.setJourOuverture(jourouverture);     
        P.setTelPropriete(Long.parseLong(telephonePropriete.getText()));
        if (livraisonOui.isSelected())
            P.setLivraison(true);
        if (livraisonNon.isSelected())
            P.setLivraison(false);
        if (prix1.isSelected())
            P.setFourchetteDePrix(1);
        if (prix2.isSelected())
            P.setFourchetteDePrix(2);
        if (prix3.isSelected())
            P.setFourchetteDePrix(3);
        if (prix4.isSelected())
            P.setFourchetteDePrix(4);
        P.setDescription(descriptionPropriete.getText());
        P.setCategorie(CS.FindCategorieByNom(typePropriete.getValue().toString()));
        System.out.println(P.toString());
        PS.modifierPropriete(P,P.getIdProptiete());
    }
    
}
