/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.utils;

/**
 *
 * @author Pilat
 */
public class OcrResponseProcessing {

    public void ocrToWordsList(String ocrString) {

        String[] ocrWords = ocrString.split("\\s+");
        for (int i = 0; i < ocrWords.length; i++) {
        ocrWords[i] = ocrWords[i].replaceAll("[^\\w]", "");
            System.out.println(ocrWords[i]);

        }
    }
}

//        String[] ocrWords = ocrString.split("\\s+");
//        for (int i = 0; i < ocrWords.length; i++) {
//        ocrWords[i] = ocrWords[i].replaceAll("[^\\w]", "");