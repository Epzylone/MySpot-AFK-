
package DataStorage;

/**
 *
 * @author Fares
 */ 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPUploadFile {


  String serveur = "localhost";
  int port = 21;
  String user = "Epzylone";
  String password = "123";

  FTPClient ftpClient = new FTPClient();
 

    public void envoyerficher (File file){
         try {

   ftpClient.connect(serveur, port);
   ftpClient.login(user, password );
   ftpClient.enterLocalPassiveMode();
   ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
   String chemin = file.getName();
   InputStream inputStream = new FileInputStream(file); 
   System.out.println("Début de l'upload");
   OutputStream outputStream = ftpClient.storeFileStream(chemin);
    
   byte[] bytesIn = new byte[4096];
   int buffer = 0;

   //tant qu'on a pas atteint la fin du fichier
   System.out.println("Transfert en cours...");
   int transferé = 0;
   int pourcentage = 0;
   //tant qu'on a pas atteint la fin du fichier
   while ((buffer = inputStream.read(bytesIn)) != -1) {
       //lire les données avec un buffer de 4096 octets
       outputStream.write(bytesIn, 0, buffer);
       transferé += buffer;
       pourcentage = (int) (transferé*100/file.length());
       System.out.println(pourcentage+"%");
   }
   //fermer les flux de lecture de d'écriture
   inputStream.close();
   outputStream.close();

   //résultat de l'upload
   boolean res = ftpClient.completePendingCommand();
   if (res) {
     System.out.println("Le fichier "+chemin+" a été transféré avec succès");
   }

  } catch (IOException e) {
   System.out.println(e.getMessage());
   e.printStackTrace();
  } finally {
     try {
    if (ftpClient.isConnected()) {
     //fermer la connexion FTP
     ftpClient.logout();
     ftpClient.disconnect();
    }
   } catch (IOException ex) {
    ex.printStackTrace();
   }
  }
 }

}
