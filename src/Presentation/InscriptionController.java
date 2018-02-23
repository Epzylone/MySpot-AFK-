/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;
import Services.UserService;
import entities.User;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class InscriptionController implements Initializable {

    @FXML
    private DatePicker tfDateNaissance;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfUserName;
    @FXML
    private TextField tfUserNom;
    @FXML
    private TextField tfUserPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField tfPasswordVerif;
    @FXML
    private TextField tfTelUser;
    @FXML
    private TextField tfDescriptionUser;
    @FXML
    private Canvas photoCanvas;
    @FXML
    private TextField tfPhotoProfile;
    @FXML
    private ImageView img;
    @FXML
    private Button inscrire;

    @FXML
    private Button annuler;
    /**
     * Initializes the controller class.
     */
    private String photo;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    @FXML
    private void inscrireAction(ActionEvent event) {
        UserService us = new UserService();
        LocalDate localdate = tfDateNaissance.getValue();
        Date date= Date.from(localdate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            
        User u = new User(tfUserName.getText(),tfUserNom.getText(),tfUserPrenom.getText(),tfEmail.getText(),tfPassword.getText(),Long.parseLong(tfTelUser.getText()),photo,date,tfDescriptionUser.getText());
        us.ajouterUser(u);
        
    }

    @FXML
    void annulerAction(MouseEvent event) {
        annuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    switchScreen("Connexion.fxml");
                } catch (IOException ex) {
                    Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    @FXML
    private void parcourirAction(ActionEvent event) {
        FileChooser fileChooser=new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        
        photo=getBitmapFromURL(selectedFile.getPath()).toString();
        
        tfPhotoProfile.setText(selectedFile.getName());
        fileChooser.getExtensionFilters().addAll(
        new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        Image image;
        try {
            image = SwingFXUtils.toFXImage(ImageIO.read(selectedFile), null);
            img.setImage(image);
        } catch (IOException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void switchScreen(String screen) throws IOException {
        Parent root = FXMLLoader.load(getClass()
                .getResource(screen));
        Scene scene = new Scene(root) ;
        Stage stage = (Stage) annuler.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }
}
