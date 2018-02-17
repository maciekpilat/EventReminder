/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.ocr;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Pilat
 */
@Service
public class UrlRequest {

    public String wysylamZapytanie(String scanUrl) {

        RestTemplate rest = new RestTemplate();

        String http = "http://";
        String ocrApiKey = "1f506d896a88957";
        String language = "pol";
        String fileType = "JPG";
        String link = scanUrl;
        
// sklejony link do API OCR
        String url = "https://api.ocr.space/parse/imageurl?apikey=" + ocrApiKey + "&url=" + link + "&language=" + language + "&isOverlayRequired=true";

// wysłanie url GETem z doklejonymi parametrami i odebranie danych        
        String res = rest.getForObject(url, String.class);
        System.out.println(res);
        
        return res;
        
    }
    

    
}

//String url3 = "https://api.ocr.space/parse/imageurl?apikey=1f506d896a88957&url=https://i.imgur.com/jOOVhAh.jpg&language=pol&isOverlayRequired=true";
//        Map<String, Object> res = rest.getForObject(url, Map.class, new HashMap<Object, Object>());