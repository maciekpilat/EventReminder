/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.controller;

import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.pilat.model.Scan;
import org.pilat.repository.ScanRepository;
import org.pilat.utils.scanFtpUpload;
import org.pilat.utils.ScanProcessing;
import org.pilat.utils.OcrResponseProcessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.pilat.ocr.UrlRequest;
import org.pilat.repository.CourtNameRepository;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author Pilat
 */
@Controller
public class AddScanController {

    @Autowired
    ScanRepository scanRepository;
    @Autowired
    CourtNameRepository courtNameRepository;

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
            System.out.println("Czy plik jest pusty: " + scan.isEmpty() + " a rozmiar to: " + scan.getSize());
            Path path = Paths.get(UPLOADED_FOLDER + scan.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "Zapisałeś plik: '" + scan.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

//zapisanie do FTP zenbox i url do MySQL zenbox
        scanFtpUpload sfu = new scanFtpUpload();
        sfu.uploadFileToFtp(scan.getBytes(), scan.getOriginalFilename());
// zapisuje dane i url dl MySQL zenbox
        String scanUrl = "http://maciekpilat.pl/eventRemainderScans/" + scan.getOriginalFilename();
        Scan s = new Scan(scanName, null, scanUrl);
        scanRepository.save(s);

// wysyłam do OCR
        UrlRequest r = new UrlRequest();

// zamieniam rozpoznany ocr na liste slow
        OcrResponseProcessing orp = new OcrResponseProcessing();
        orp.ocrToWordsList(r.wysylamZapytanie(scanUrl));

// zamiana JASON na liste obiektow        
        orp.jsonToList(r.wysylamZapytanie(scanUrl));
        

// native query
//System.out.println("To są pobrane kolumny 1: " + courtNameRepository.getCourtName1().toString()); // mozna usunac
//System.out.println("To są pobrane kolumny 2: " + courtNameRepository.getCourtName2().toString()); // mozna usunac
//System.out.println("To są pobrane kolumny 3: " + courtNameRepository.getCourtName3().toString()); // mozna usunac

orp.courtAdressFinder(orp.jsonToList(r.wysylamZapytanie(scanUrl)));


        return "redirect:/addscan";
    }

}

//Scan s = new Scan(scanName, scan.getBytes(),scanUrl);
// sprawdzanie rozmiaru i kompresja
// zapisuję obiekt do bazy MySQL zenbox
//Scan s = new Scan(scanName, scan.getBytes());
//scanRepository.save(s);
// sprawdzam rozmiar i kompresuję
//        scanFtpUpload sfu = new scanFtpUpload();
//        while (scan.getSize() > 900000) {
//            ScanProcessing sp = new ScanProcessing();
//            sp.resizeScanBytes(scan.getBytes());
//        }

//r.wysylamZapytanie(scanUrl); //jakby co odkomentuj
