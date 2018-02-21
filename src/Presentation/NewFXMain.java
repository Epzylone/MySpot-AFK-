/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import entities.AppModel;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Fares
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
          try {
            Parent root = FXMLLoader.load(getClass()
                .getResource("Propriete.fxml"));
       /* final ImageView selectedImage = new ImageView();   
        Image image1 = new Image(Main.class.getResourceAsStream("a.jpg"));
        
        selectedImage.setImage(image1);
        
        root.getChildren().addAll(selectedImage);*/
       /*File file = new File("C:/Users/Fares/Pictures/Wallpaper/2018_bugatti_chiron-HD.jpg");
         StackPane sp = new StackPane();
        Image img = new Image(file.toURI().toString());
        ImageView imgView = new ImageView(img);

        sp.getChildren().add(imgView);
            Scene scene1 = new Scene(sp);*/
           
             //AppModel model = new AppModel();


/*FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("Propriete.fxml"));
firstLoader.setController(new ProprieteController(model));
Parent firstUI = firstLoader.load();

FXMLLoader secondLoader = new FXMLLoader(getClass().getResource("AjoutImagePropriete.fxml"));
secondLoader.setController(new AjoutImageProprieteController(model));
Parent secondUI = secondLoader.load();*/
             Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("PiDev");
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
          
    }
   
/*FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("Propriete.fxml"));
firstLoader.setControllerFactory(controllerFactory);
Parent firstUI = firstLoader.load();

FXMLLoader secondLoader = new FXMLLoader(getClass().getResource("AjoutImagePropriete.fxml"));
secondLoader.setControllerFactory(controllerFactory);
Parent secondUI = secondLoader.load();
*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        


    }
    
}
