/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.pilat.model.Scan;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tomcat.util.http.fileupload.FileUtils;

/**
 *
 * @author Pilat
 */
public class scanFtpUpload {

    public void uploadFileToFtp(byte[] scanByte, String scanName) throws IOException {

        FTPClient client = new FTPClient();

        String filename = scanName + ".jpg";

        //FileUtils.writeByteArrayToFile(new File("pathname"), scanByte);
        // Read the file from resources folder.
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream input = new ByteArrayInputStream(scanByte)) {
            client.connect("s26.zenbox.pl");

            client.login("eventRemainder@maciekpilat.pl", "sys");

            // Store file to server / destination folder
            client.changeWorkingDirectory("/eventRemainderScans");

            // ustawienie typu transferu dla ftp
            client.setFileType(client.BINARY_FILE_TYPE);// dodane ale nic nie zmienia
            client.setFileTransferMode(client.BINARY_FILE_TYPE); //dodane  ale nic nie zmienia

            client.storeFile(filename, input);
            input.close();// dopisane nie poprawia
            client.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//  inne podejście ale efekt ten sam
//        try (FileOutputStream fos = new FileOutputStream("E://EVENTREMAINDER//test.jpg")) {
//            fos.write(scanByte);
//            fos.close();
//        }
//
//        File file = new File("E://EVENTREMAINDER//test.jpg");
//
//        FTPClient client = new FTPClient();
//
//        String filename = scanName + ".jpg";
//
//        // Read the file from resources folder.
//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
//
//        client.connect("s26.zenbox.pl");
//        client.login("eventRemainder@maciekpilat.pl", "sys");
//        client.storeFile("File Name", bis);
//        bis.close();
//        client.logout();
//
//
//            // Store file to server / destination folder
//            client.changeWorkingDirectory("/eventRemainderScans");
//            
//            // ustawienie typu transferu dla ftp
//            client.setFileType(client.BINARY_FILE_TYPE);// dodane ale nic nie zmienia
//            client.setFileTransferMode(client.BINARY_FILE_TYPE); //dodane  ale nic nie zmienia
//
//            
//            client.storeFile(filename, input);
//            input.close();// dopisane nie poprawia
//            client.logout();

