/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.ProprieteService;
import entities.Propriete;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author Fares
 */
public class AfficherBonPlanController implements Initializable {

    @FXML
    private TableColumn<?, ?> photo;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> fourchette;
    @FXML
    private TableColumn<?, ?> livraison;
    @FXML
    private TableView tab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*File file3 = new File("C:/Users/Fares/Documents/IMGPIDEV/restaurant.png");
            String localUrl3;
            localUrl3 = file3.toURI().toURL().toString();
            Image imgdejeuner = new Image(localUrl3);
            dejeuner.setImage(imgdejeuner);*/
        //TextField Name=new TextField();
      Propriete P = new Propriete();
      ProprieteService PS = new ProprieteService();
     photo.setCellValueFactory(new PropertyValueFactory<>("photo"));
      nom.setCellValueFactory(new PropertyValueFactory<>("nomPropriete"));
      fourchette.setCellValueFactory(new PropertyValueFactory<>("fourchetteDePrix"));
      livraison.setCellValueFactory(new PropertyValueFactory<>("livraison"));
      //activeCol.setCellValueFactory(new PropertyValueFactory<>("active"));
      
      ObservableList<Propriete> list = PS.lirePropriete();
      tab.setItems(list);
      //photo.getCellObservableValue(0);
     // tab.getColumns().set(0, list.get(0).getNomPropriete());
     
 
    // tab.getColumns().addAll(photo, nom, fourchette, livraison); 
        
    }    
    
}
