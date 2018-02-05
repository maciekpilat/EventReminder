/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.pilat.model.Scan;
import org.pilat.repository.ScanRepository;
import org.pilat.utils.scanFtpUpload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Pilat
 */
@Controller
public class AddScanController {
    
    @Autowired
    ScanRepository scanRepository;

    private static String UPLOADED_FOLDER = "E://EVENTREMAINDER//";

    // wywołanie formularza
    @GetMapping("/addscan")
    public String addDocument() {

        return "addscan";
    }

    // odebranie pliku i zapis
    @PostMapping("/addscan")
    public String addAdressForm(@RequestParam("scanName") String scanName, @RequestParam("scan") MultipartFile scan, RedirectAttributes redirectAttributes) throws IOException {

        if (scan.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Wybierz skan dokumentu!");
            return "redirect:addscan";
        }

        try {

            // Tworzy plik i zapisuje tam gdzie wskazuje stala
            byte[] bytes = scan.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + scan.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "Zapisałeś plik: '" + scan.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // zapisuję obiekt do bazy MySQL zenbox
        Scan s = new Scan(scanName, scan.getBytes());
        scanRepository.save(s);
        
        //zapisanie do FTP zenbox
        scanFtpUpload sfu = new scanFtpUpload();
        sfu.uploadFileToFtp(scan.getBytes(), scanName);

        return "redirect:/addscan";
    }

}
