/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package DataStorage;

/**
 *
 * @author Fares
 */
/*
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPUploadFile {
	
	FTPClient ftp = null;
	
	public FTPUploadFile(String host, String user, String pwd) throws Exception{
		ftp = new FTPClient();
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		int reply;
		ftp.connect(host);
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			throw new Exception("Exception in connecting to FTP Server");
		}
		ftp.login(user, pwd);
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
	}
	public void uploadFile(String localFileFullName, String fileName, String hostDir)
			throws Exception {
		try(InputStream input = new FileInputStream(new File(localFileFullName))){
		this.ftp.storeFile(hostDir + fileName, input);
		}
	}

	public void disconnect(){
		if (this.ftp.isConnected()) {
			try {
				this.ftp.logout();
				this.ftp.disconnect();
			} catch (IOException f) {
				// do nothing as file is already saved to server
			}
		}
	}
	/*public static void main(String[] args) throws Exception {
		System.out.println("Start");
		FTPUploadFile ftpUploaderFile = new FTPUploadFile("ftp.journaldev.com", "ftpUser", "ftpPassword");
		//FTP server path is relative. So if FTP account HOME directory is "/home/pankaj/public_html/" and you need to upload 
		// files to "/home/pankaj/public_html/wp-content/uploads/image2/", you should pass directory parameter as "/wp-content/uploads/image2/"
		ftpUploaderFile.uploadFile("D:\\Pankaj\\images\\MyImage.png", "image.png", "/wp-content/uploads/image2/");
		ftpUploaderFile.disconnect();
		System.out.println("Done");
	}

}
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 
/*
   // Approche 1: upload d'un fichier en utilisant InputStream
   File file = new File("C:/plugins et styles.txt");

   String chemin = "plugins et styles.txt";
   InputStream inputStream = new FileInputStream(file);

   System.out.println("Début de l'upload");
   //résultat de l'upload
   boolean res = ftpClient.storeFile(chemin, inputStream);
   //fermet le flut de lecture
   inputStream.close();
   
   if (res==true) {
     System.out.println("Le fichier "+chemin+" a été transféré avec succès");
   }
*/
    public void envoyerficher (File file){
         try {

   ftpClient.connect(serveur, port);
   ftpClient.login(user, password );
   ftpClient.enterLocalPassiveMode();

   ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
   // Approche 2: upload d'un fichier en utilisant OutputStream
  // File file = new File("C:/piste 1.wma");
   String chemin = file.getName();
   InputStream inputStream = new FileInputStream(file);
//File file = new File("C:/plugins et styles.txt");

   //String chemin = "plugins et styles.txt";
   //InputStream inputStream = new FileInputStream(file);
/*
   System.out.println("Début de l'upload");
   //résultat de l'upload
   boolean res = ftpClient.storeFile(chemin, inputStream);
   //fermet le flut de lecture
   inputStream.close();
   
   if (res==true) {
     System.out.println("Le fichier "+chemin+" a été transféré avec succès");
   
   }
   
   */
 
   
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
