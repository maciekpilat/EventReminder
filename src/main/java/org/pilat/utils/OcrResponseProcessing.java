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
import org.json.simple.JSONArray;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.pilat.model.Word;
import org.pilat.model.WordsList;
import com.google.gson.JsonObject;

/**
 *
 * @author Pilat
 */
public class OcrResponseProcessing {

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
    public WordsList jsonToList(String string) {

        Gson gson = new Gson();
        Object obj;

        JsonParser parser = new JsonParser();
        obj = parser.parse(string);
        JsonObject jsonObject = (JsonObject) obj;

        WordsList wordsList = gson.fromJson(jsonObject, WordsList.class);

            
        
        return wordsList;
    }

}

//JSONObject jo = new JSONObject(string);
//Gson gson = new GsonBuilder().create();
        //Word word = gson.fromJson(jo.getJSONObject("word").toString(), Word.class);
