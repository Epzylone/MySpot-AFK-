/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DataStorage.FTPUploadFile;
import Services.ProprieteService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import Presentation.ProprieteController;
import Services.PhotoProprieteService;
import entities.AppModel;
import entities.PhotoPropriete;
import entities.Propriete;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
/**
 * FXML Controller class
 *
 * @author Fares
 */
public class AjoutImageProprieteController implements Initializable {

    @FXML
    private Button ajouter;
    @FXML
    private TextField imagePropriete;
    @FXML
    private ImageView image;
    @FXML
    private Button parcourir;

    FileChooser filechooser=new FileChooser();
    @FXML
    private Button ajoutPropriete;
  //  private final AppModel model;    
    
   // public AjoutImageProprieteController(AppModel model){
       // this.model = model;
   // }
     ProprieteService PS = new ProprieteService();
     Propriete P = new Propriete();
     PhotoProprieteService PPS = new PhotoProprieteService();
     PhotoPropriete PP = new PhotoPropriete();
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

         
       
        P = PS.getProprieteByTel(ProprieteController.TEL);
         
    }    

    @FXML
    private void AjouterImageAction(ActionEvent event) {
         
         PP.setIdPropriete(P.getIdProptiete());
         System.out.println(PP.toString());
         PPS.ajouterPhotoPropriete(PP);
    }

    @FXML
    private void ParcourirAction(ActionEvent event) {
        try {
            FileChooser fileChooser=new FileChooser();
            File infile = filechooser.showOpenDialog(null);
            Image img = SwingFXUtils.toFXImage(ImageIO.read(infile), null);
            image.setImage(img);
            fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", ".png", ".jpg", "*.gif"));
            imagePropriete.setText(infile.getPath());
            FTPUploadFile F= new FTPUploadFile();
            System.out.println(infile.getPath());
            F.envoyerficher(infile);
            PP.setURLphoto(imagePropriete.getText());
           // PP.setURLphoto(getBitmapFromURL(imagePropriete.getText()).toString());
        } catch (IOException ex) {
            Logger.getLogger(ProprieteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public static byte[] getBitmapFromURL(String src) {
    try {
    	BufferedImage image= ImageIO.read(new File(src));

    	BufferedImage myBitmap =  new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graph = myBitmap.createGraphics();
        graph.drawImage(image, 0, 0, null);
        graph.dispose();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(myBitmap, "jpg", baos);
        baos.flush();
        byte byteStream[]=baos.toByteArray();
        return byteStream;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}
   //fx:controller="Presentation.AjoutImageProprieteController"
    
}
