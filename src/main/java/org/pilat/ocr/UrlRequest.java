/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.ocr;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Pilat
 */
public class UrlRequest {

    public void wysylamZapytanie(String scanUrl) {

        RestTemplate rest = new RestTemplate();

        String http = "http://";
        String ocrApiKey = "1f506d896a88957";
        String image = "https://i.imgur.com/jOOVhAh.jpg";
        String language = "pol";
        String fileType = "JPG";
        String link = scanUrl;
        //String link = "https://i.imgur.com/jOOVhAh.jpg";

        String url = "https://api.ocr.space/parse/imageurl?apikey=" + ocrApiKey + "&url=" + image + "&language=" + language + "&isOverlayRequired=true";
        
//        Map<String, Object> res = rest.getForObject(url, Map.class, new HashMap<Object, Object>());
        String res = rest.getForObject(url, String.class);
        System.out.println(res);
    }
}

//String url3 = "https://api.ocr.space/parse/imageurl?apikey=1f506d896a88957&url=https://i.imgur.com/jOOVhAh.jpg&language=pol&isOverlayRequired=true";