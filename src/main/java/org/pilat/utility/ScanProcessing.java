/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 *
 * @author Pilat
 */

// NIE DZIAŁA
public class ScanProcessing {

    public File resizeScanFile(File scan) throws IOException {

        File input = scan;
        BufferedImage image = ImageIO.read(input);

        File compressedImageFile = new File("compress.jpg");
        OutputStream os = new FileOutputStream(compressedImageFile);

        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = (ImageWriter) writers.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();

        // ustawienie stopnia kompresji
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.1f);
        writer.write(null, new IIOImage(image, null, null), param);

        os.close();
        ios.close();
        writer.dispose();

        return input;
    }

    public byte[] resizeScanBytes(byte[] byteScan) throws IOException {
// zamieniam byte na file
        try (FileOutputStream fos = new FileOutputStream("E:\\EVENTREMAINDER\\temp.jpg")) {
            fos.write(byteScan);
            fos.close();
        }
        File input = new File("E:\\EVENTREMAINDER\\temp.jpg");
        BufferedImage image = ImageIO.read(input);

        File compressedImageFile = new File("compress.jpg");
        OutputStream os = new FileOutputStream(compressedImageFile);

        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = (ImageWriter) writers.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();

        // ustawienie stopnia kompresji
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.1f);
        writer.write(null, new IIOImage(image, null, null), param);
        os.close();
        ios.close();
        writer.dispose();

        // zamieniam na byte
        Path path = Paths.get("E:\\EVENTREMAINDER\\temp.jpg");
        byte[] data = Files.readAllBytes(path);

        return data;
    }

}
