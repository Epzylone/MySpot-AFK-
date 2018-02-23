/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.ReclamationService;
import entities.Reclamation;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReclamationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ListView<HBoxCell> fieldReclamation;
    
    public static class HBoxCell extends HBox {
          Label label = new Label();
          Button voir = new Button();
          Button supprimer = new Button();
          Button ignorer = new Button();
          HBoxCell(String labelText) {
               super();

               label.setText(labelText);
               label.setMaxWidth(Double.MAX_VALUE);
               HBox.setHgrow(label, Priority.ALWAYS);
               voir.setText("Voir");
               supprimer.setText("Supprimer");
               ignorer.setText("Garder");
               voir.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                   
               }
               });
               supprimer.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                    
               }
               });
               ignorer.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                    
               }
               });

               this.getChildren().addAll(label, supprimer, voir, ignorer);
          }
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ReclamationService rs = new ReclamationService();
        List<Reclamation> L= rs.consulterReclamation();
        //ObservableList<Reclamation> list = FXCollections.observableArrayList();
        /*for(int i=0;i<L.size();i++)
        {
            list.add(L.get(i));   
        }
        fieldReclamation.setItems(list);
       */
        List<HBoxCell> list = new ArrayList<>();
          for (int i = 0; i < L.size(); i++) {
               list.add(new HBoxCell(L.get(i).toString()));
          }

          ListView<HBoxCell> listView = new ListView<HBoxCell>();
          ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
          fieldReclamation.setItems(myObservableList);

        

    }    
    
}
