/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Fares
 */
public class ChercherBonPlanController implements Initializable {

    @FXML
    private ImageView sortir;
    @FXML
    private ImageView diner;
    @FXML
    private ImageView dejeuner;
    @FXML
    private ImageView petitdej;
    @FXML
    private ImageView cafe;
    @FXML
    private ImageView cinema;
    @FXML
    private ImageView theatre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO try {     
        try {
            File file = new File("C:/Users/Fares/Documents/IMGPIDEV/cinema.png");
            String localUrl;
            localUrl = file.toURI().toURL().toString();
            Image imgcinema = new Image(localUrl);
            cinema.setImage(imgcinema);
            
            File file2 = new File("C:/Users/Fares/Documents/IMGPIDEV/petitdej.png");
            String localUrl2;
            localUrl2 = file2.toURI().toURL().toString();
            Image imgpetitdej = new Image(localUrl2);
            petitdej.setImage(imgpetitdej);
            
            File file3 = new File("C:/Users/Fares/Documents/IMGPIDEV/restaurant.png");
            String localUrl3;
            localUrl3 = file3.toURI().toURL().toString();
            Image imgdejeuner = new Image(localUrl3);
            dejeuner.setImage(imgdejeuner);
            
             File file4 = new File("C:/Users/Fares/Documents/IMGPIDEV/dinner.png");
            String localUrl4;
            localUrl4 = file4.toURI().toURL().toString();
            Image imgdiner = new Image(localUrl4);
            diner.setImage(imgdiner);
             
            File file5 = new File("C:/Users/Fares/Documents/IMGPIDEV/theater.png");
            String localUrl5;
            localUrl5 = file5.toURI().toURL().toString();
            Image imgtheatre = new Image(localUrl5);
            theatre.setImage(imgtheatre);
             
            File file6 = new File("C:/Users/Fares/Documents/IMGPIDEV/sortir.png");
            String localUrl6;
            localUrl6 = file6.toURI().toURL().toString();
            Image imgsortir = new Image(localUrl6);
            sortir.setImage(imgsortir);
            
            File file7 = new File("C:/Users/Fares/Documents/IMGPIDEV/cafe.png");
            String localUrl7;
            localUrl7 = file7.toURI().toURL().toString();
            Image imgcafe = new Image(localUrl7);
            cafe.setImage(imgcafe);
            
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(ChercherBonPlanController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
       
      
    
    }

    @FXML
    private void chercherSortir(MouseEvent event) {
    }

    @FXML
    private void chercherDiner(MouseEvent event) {
    }

    @FXML
    private void chercherDejeuner(MouseEvent event) {
    }

    @FXML
    private void chercherPetitdej(MouseEvent event) {
    }

    @FXML
    private void chercherCafe(MouseEvent event) {
    }

    @FXML
    private void chercherCinema(MouseEvent event) {
    }

    @FXML
    private void chercherTheatre(MouseEvent event) {
    }
}
