/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.utils;

import java.io.ByteArrayInputStream;
import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Pilat
 */
public class scanFtpUpload {

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
            client.changeWorkingDirectory("/eventRemainderScans");
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
