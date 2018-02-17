/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.utility;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pilat
 */
@Service
public class ScanFtpUpload {

    public void uploadFileToFtp(byte[] scanByte, String scanName) throws IOException {
        System.out.println("To jest nazwa pliku: " + scanName);
        FTPClient client = new FTPClient();

        // Read the file from resources folder.
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream input = new ByteArrayInputStream(scanByte)) {
            client.connect("s26.zenbox.pl");
            client.login("eventRemainder@maciekpilat.pl", "sys");
            client.enterLocalPassiveMode();
            // Store file to server / destination folder
            //client.changeWorkingDirectory("/eventRemainderScans");
            client.changeWorkingDirectory("/public_html/eventRemainderScans");

            // ustawienie typu transferu dla ftp
            client.setFileType(client.BINARY_FILE_TYPE);// dodane ale nic nie zmienia
            client.setFileTransferMode(client.BINARY_FILE_TYPE); //dodane  ale nic nie zmienia
            client.storeFile(scanName, input);
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
