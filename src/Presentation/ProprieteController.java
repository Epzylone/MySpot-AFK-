/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.CategorieService;
import Services.PhotoProprieteService;
import Services.ProduitService;
import Services.ProprieteService;
import entities.AppModel;
import entities.PhotoPropriete;
import entities.Propriete;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
/**
 * FXML Controller class
 *
 * @author Fares
 */
    
    
public class ProprieteController implements Initializable {
    
    @FXML
    private TextField nomPropriete;

    @FXML
    private TextField adressePropriete;

    @FXML
    private TextField villePropriete;


    @FXML
    private ComboBox typePropriete;

    @FXML
    private CheckBox dimanche;

    @FXML
    private CheckBox lundi;

    @FXML
    private CheckBox samedi;

    @FXML
    private CheckBox vendredi;

    @FXML
    private CheckBox jeudi;

    @FXML
    private CheckBox mercredi;

    @FXML
    private CheckBox mardi;

    @FXML
    private TextArea descriptionPropriete;

    @FXML
    private TextField telephonePropriete;

    @FXML
    private RadioButton livraisonOui;

    @FXML
    private RadioButton livraisonNon;

    
    @FXML
    private Button add;
    
   
    @FXML
    private RadioButton prix1;

    @FXML
    private RadioButton prix2;

    @FXML
    private RadioButton prix3;

    @FXML
    private RadioButton prix4;
    
    @FXML
    private ImageView image;
    
    FileChooser filechooser=new FileChooser();
    
    // private final AppModel model;
    
   // public ProprieteController(AppModel model){
        //this.model = model;
    //}
   // String screen="AjoutImageProprieteController";
  
    /**
     * Initializes the controller class.
     */
    public static long TEL;
    @FXML
    private Button chercher;
    @FXML
    private Button modifierprop;
    @FXML
    private Button afficher;
    @FXML
    private Button categorie;
    @FXML
    private Button crit;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategorieService CS = new CategorieService();
        System.out.println(CS.getAllCategorie().size());
        typePropriete.getItems().setAll(CS.getAllCategorie());
        final ToggleGroup group = new ToggleGroup();
        livraisonOui.setToggleGroup(group);
        livraisonOui.setSelected(true);
        livraisonNon.setToggleGroup(group);
        final ToggleGroup group2 = new ToggleGroup();
        prix1.setToggleGroup(group2);
        prix1.setSelected(true);
        prix2.setToggleGroup(group2);
        prix3.setToggleGroup(group2);
        prix4.setToggleGroup(group2);
      
        
    }
 

    @FXML
    void addAction(ActionEvent event) throws IOException { 
        Date aujourdhui = new Date();
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
        DateFormat.SHORT,
        DateFormat.SHORT);
        ProprieteService ps = new ProprieteService();
        Propriete P = new Propriete();
        P.setDateAjout(aujourdhui);
        P.setNomPropriete(nomPropriete.getText());
        P.setAdressePropriete(adressePropriete.getText());
        P.setVille(villePropriete.getText());
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
        CategorieService CS = new CategorieService();
        P.setCategorie(CS.FindCategorieByNom(typePropriete.getValue().toString()));
        System.out.println(P.toString());
        TEL=Long.parseLong(telephonePropriete.getText());
        ps.ajouterPropriete(P);
       // model.setText(telephonePropriete.getText());
       
       switchScreen("AjoutImagePropriete.fxml");        
        
        
    }
//fx:controller="Presentation.ProprieteController"
        
   

    public void switchScreen(String screen) throws IOException {
        Parent root = FXMLLoader.load(getClass()
                .getResource(screen));
        Scene scene = new Scene(root) ;
        Stage stage = (Stage) add.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void chercherAction(ActionEvent event) throws IOException {
         switchScreen("ChercherBonPlan.fxml"); 
    }

    @FXML
    private void modifierAction(ActionEvent event) throws IOException {
         switchScreen("ModifierPropriete.fxml"); 
    }
    
    @FXML
    private void afficherAction(ActionEvent event) throws IOException {
        switchScreen("AfficherBonPlan.fxml"); 
    }

    @FXML
    private void addCat(ActionEvent event) throws IOException {
        switchScreen("Categorie.fxml"); 
    }

    @FXML
    private void critereevaluation(ActionEvent event) throws IOException {
         switchScreen("CritereEvaluation.fxml"); 
    }
}
