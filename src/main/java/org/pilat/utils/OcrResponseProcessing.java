/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
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
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

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

        return wordsList;
    }
}
