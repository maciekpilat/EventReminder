/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.json.JSONObject;
import org.pilat.model.Word;
import java.io.IOException;
import org.pilat.repository.CourtNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.pilat.model.CourtName;

/**
 *
 * @author Pilat
 */
public class OcrResponseProcessing {

    @Autowired
    CourtNameRepository courtNameRepository;
    
    
    

// metoda bierze String i kazde słowo zapisuje jako String w liscie
    public String[] ocrToWordsList(String ocrString) {

        String[] ocrWords = ocrString.split("\\s+");
        for (int i = 0; i < ocrWords.length; i++) {
            ocrWords[i] = ocrWords[i].replaceAll("[^\\w]", "");
            System.out.println(ocrWords[i]);
        }
        return ocrWords;
    }

// metoda kasuje słowa nie bedace trescia skanu (zonaczenia łamania lini itp)
    public String[] deleteUnwantedWords(String[] scanWords, String[] listOfWordsToRemove) {

// zamiana tablicy z rozpoznanym tekstem na listę 
        List<String> wordList = new ArrayList<String>(Arrays.asList(scanWords));

        List<String> unwantedWordsList = new ArrayList<String>(Arrays.asList(listOfWordsToRemove));

        String[] list = wordList.stream().map(statement -> Arrays.asList(statement.split(" ")))
                .map(listOfWords -> listOfWords.stream()
                .filter(word -> !wordList.contains(word))
                .collect(Collectors.joining(" "))
                ).toArray(String[]::new);
        List<String> filteredList = Arrays.asList(list);

        return null;
    }

// zmienia JSON w liste slow
    public List jsonToList(String string) throws IOException {

//1. zamieniam string na Object
        JSONObject jo1 = new JSONObject(string);
//2. Object zamieniam na JSONArray
        org.json.JSONArray ja1 = jo1.getJSONArray("ParsedResults");
//3. Zeby czesc ktora chce wziac pakuje jako kolejny obiekt
        JSONObject jo2 = ja1.getJSONObject(0);
        JSONObject jo3 = jo2.getJSONObject("TextOverlay");
        org.json.JSONArray ja2 = jo3.getJSONArray("Lines");

        List<Word> wordsList = new ArrayList<Word>();

        for (int i = 0; i < ja2.length(); i++) {
            JSONObject jo4 = ja2.getJSONObject(i);
            org.json.JSONArray ja3 = jo4.getJSONArray("Words");

            for (int e = 0; e < ja3.length(); e++) {
                JSONObject jo5 = ja3.getJSONObject(e);

                long left = jo5.getLong("Left");
                long top = jo5.getLong("Top");
                long height = jo5.getLong("Height");
                String wordText = jo5.getString("WordText");
                long width = jo5.getLong("Width");

                Word word = new Word(wordText, left, top, height, width);

                wordsList.add(word);
            }
        }
        System.out.println("To jest lista, która powstaje z JSON: " + wordsList);
        return wordsList;
    }

    public void courtAdressFinder(List<Word> wordsList
    //, List<CourtName> list1, List<CourtName> list2, List<CourtName> list3
    ) {
        
        
        List<CourtName> courtNameList1 = courtNameRepository.getCourtName1();
        System.out.println("To jest lista z courtAdressFinder: " + courtNameList1.toString());
//
//        ArrayList<Word> wl = wordsList.toArray(Word);
//        ArrayList<CourtName> courtNameList1 = list1.toArray(CourtName); //= courtNameRepository.getCourtName1();
//        ArrayList<CourtName> courtNameList2 = list2.toArray(CourtName); //= courtNameRepository.getCourtName2();
//        ArrayList<CourtName> courtNameList3 = list3.toArray(CourtName); //= courtNameRepository.getCourtName3();
//
//        ArrayList<String> finalCourtNameList = null;
//
//        for (Word w : wordsList) {
//
//            for (Object o : courtNameList1) {
//
//                if (w.getWordText() == o.toString()) {
//                    finalCourtNameList.add(w.getWordText());
//                    System.out.println("Znalazłem i zapisałem słowo z nazwy: " + finalCourtNameList.toString());
//
//                }
//
//            }
//
//        }

//        for (int w = 0; w <= wordsList.size(); w++) {
//
//            for (int i = 0; i <= courtNameList2.size(); i++) {
//
//                if (wordsList.get(w).getWordText() == courtNameList2.get(i).toString()) {
//                    finalCourtNameList.add(wordsList.get(w));
//
//                }
//
//            }
//
//        }
        //courtNameRepository.getCourtName1().toString()
        //Stream<Word> stream = wordsList.stream();
        //stream = stream.filter(s -> s.getWordText().contains(); //courtNameRepository.getCourtName1().toString())
        //List<Word> wynik = stream.collect(Collectors.toList());
        //System.out.println(wynik.toString());        
        //if(wynik.size()!= 0){           
        //}
    }
}
