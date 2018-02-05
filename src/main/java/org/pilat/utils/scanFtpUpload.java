/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
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

    public void uploadFileToFtp(byte[] scanByte, String scanName) {

        FTPClient client = new FTPClient();

        String filename = scanName;
        
        //FileUtils.writeByteArrayToFile(new File("pathname"), scanByte);
        

        // Read the file from resources folder.
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream input = new ByteArrayInputStream(scanByte)) {
            client.connect("s26.zenbox.pl");
            client.login("eventRemainder@maciekpilat.pl", "sys");

            // Store file to server / destination folder
            client.changeWorkingDirectory("/eventRemainderScans");
            client.storeFile(filename, input);
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
