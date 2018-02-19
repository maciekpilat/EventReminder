/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.json.JSONObject;
import java.io.IOException;
import org.pilat.repository.CourtNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.pilat.model.Word;
import org.pilat.repository.CourtDepartmentNameRepository;
import org.pilat.repository.CourtFileReferenceRepository;

/**
 *
 * @author Pilat
 */
@Component
public class OcrResponseProcessing {

    @Autowired
    CourtNameRepository courtNameRepository;
    @Autowired
    CourtDepartmentNameRepository courtDepartmentNameRepository;
    @Autowired
    CourtFileReferenceRepository courtFileReferenceRepository;

// metoda bierze String i kazde słowo zapisuje jako String w liscie
    public String[] ocrToWordsList(String ocrString) {

        String[] ocrWords = ocrString.split("\\s+");
        for (int i = 0; i < ocrWords.length; i++) {
            ocrWords[i] = ocrWords[i].replaceAll("[^\\w]", "");
            //System.out.println(ocrWords[i]);
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
        //System.out.println("To jest lista, która powstaje z JSON: " + wordsList);
        return wordsList;
    }

    public void courtAdressFinder(List<Word> wordsList) {

        List<String> finalCourtNameList = new ArrayList<>();
        ArrayList<String> courtNameCol1 = courtNameRepository.getCourtName1();
        ArrayList<String> courtNameCol2 = courtNameRepository.getCourtName2();
        ArrayList<String> courtNameCol3 = courtNameRepository.getCourtName3();
        System.out.println("courtNameCol1" + courtNameCol1);
        System.out.println("courtNameCol2" + courtNameCol2);
        System.out.println("courtNameCol3" + courtNameCol3);

        outerLoop:
        for (int i = 0; i <= wordsList.size(); i++) {

            for (String s1 : courtNameCol1) {
                if (s1.equalsIgnoreCase(wordsList.get(i).getWordText().toString())) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtNameList.add(wordsList.get(i).getWordText().toString());
                }
                break;
            }
            for (String s2 : courtNameCol2) {
                if (s2.equalsIgnoreCase(wordsList.get(i).getWordText().toString())) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtNameList.add(wordsList.get(i).getWordText().toString());

                }
                break;
            }
            for (String s3 : courtNameCol3) {
                if (wordsList.get(i).getWordText().toString().equalsIgnoreCase(s3)) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtNameList.add(wordsList.get(i).getWordText().toString());
                    finalCourtNameList.add(wordsList.get(i + 1).getWordText().toString());
                    System.out.println("Nazwa sądu to: " + finalCourtNameList.toString());
                    break outerLoop;
                }

            }
        }

    }

    public void courtDepartmentNameFinder(List<Word> wordsList) {
        List<String> finalCourtDepartmentNameList = new ArrayList<>();
        ArrayList<String> courtDepartmentNameCol1 = courtDepartmentNameRepository.getCourtDepartmentName1();
        ArrayList<String> courtDepartmentNameCol2 = courtDepartmentNameRepository.getCourtDepartmentName2();
        ArrayList<String> courtDepartmentNameCol3 = courtDepartmentNameRepository.getCourtDepartmentName3();
        ArrayList<String> courtDepartmentNameCol4 = courtDepartmentNameRepository.getCourtDepartmentName4();
        ArrayList<String> courtDepartmentNameCol5 = courtDepartmentNameRepository.getCourtDepartmentName5();
        ArrayList<String> courtDepartmentNameCol6 = courtDepartmentNameRepository.getCourtDepartmentName6();
        ArrayList<String> courtDepartmentNameCol7 = courtDepartmentNameRepository.getCourtDepartmentName7();
        ArrayList<String> courtDepartmentNameCol8 = courtDepartmentNameRepository.getCourtDepartmentName8();
        System.out.println("courtDepartmentNameCol1: " + courtDepartmentNameRepository.getCourtDepartmentName1());
        System.out.println("courtDepartmentNameCol2: " + courtDepartmentNameRepository.getCourtDepartmentName2());
        System.out.println("courtDepartmentNameCol3: " + courtDepartmentNameRepository.getCourtDepartmentName3());
        System.out.println("courtDepartmentNameCol4: " + courtDepartmentNameRepository.getCourtDepartmentName4());
        System.out.println("courtDepartmentNameCol5: " + courtDepartmentNameRepository.getCourtDepartmentName5());
        System.out.println("courtDepartmentNameCol6: " + courtDepartmentNameRepository.getCourtDepartmentName6());
        System.out.println("courtDepartmentNameCol7: " + courtDepartmentNameRepository.getCourtDepartmentName7());
        System.out.println("courtDepartmentNameCol8: " + courtDepartmentNameRepository.getCourtDepartmentName8());

        outerLoop:
        for (int i = 0; i <= wordsList.size(); i++) {

            for (String s1 : courtDepartmentNameCol1) {
                if (s1.equalsIgnoreCase(wordsList.get(i).getWordText().toString())) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtDepartmentNameList.add(wordsList.get(i).getWordText().toString());
                }
                break;
            }
            for (String s2 : courtDepartmentNameCol2) {
                if (s2.equalsIgnoreCase(wordsList.get(i).getWordText().toString())) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtDepartmentNameList.add(wordsList.get(i).getWordText().toString());

                }
                break;
            }
            for (String s3 : courtDepartmentNameCol3) {
                if (wordsList.get(i).getWordText().toString().equalsIgnoreCase(s3)) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtDepartmentNameList.add(wordsList.get(i).getWordText().toString());
                    //finalCourtDepartmentNameList.add(wordsList.get(i + 1).getWordText().toString());
                    System.out.println("Nazwa sądu to: " + finalCourtDepartmentNameList.toString());
                    break outerLoop;
                }

            }
        }
    }

    public void courtFileReferenceFinder(List<Word> wordsList) {
        List<String> finalCourtFileReferenceColList = new ArrayList<>();
        ArrayList<String> courtFileReferenceCol1 = courtFileReferenceRepository.courtFileReference1();
        ArrayList<String> courtFileReferenceCol2 = courtFileReferenceRepository.courtFileReference2();
        ArrayList<String> courtFileReferenceCol3 = courtFileReferenceRepository.courtFileReference3();
        ArrayList<String> courtFileReferenceCol4 = courtFileReferenceRepository.courtFileReference4();
        ArrayList<String> courtFileReferenceCol5 = courtFileReferenceRepository.courtFileReference5();
        ArrayList<String> courtFileReferenceCol6 = courtFileReferenceRepository.courtFileReference6();
        ArrayList<String> courtFileReferenceCol7 = courtFileReferenceRepository.courtFileReference7();
        ArrayList<String> courtFileReferenceCol8 = courtFileReferenceRepository.courtFileReference8();
        ArrayList<String> courtFileReferenceCol9 = courtFileReferenceRepository.courtFileReference9();
        ArrayList<String> courtFileReferenceCol10 = courtFileReferenceRepository.courtFileReference10();
        ArrayList<String> courtFileReferenceCol11 = courtFileReferenceRepository.courtFileReference11();
        ArrayList<String> courtFileReferenceCol12 = courtFileReferenceRepository.courtFileReference12();

        System.out.println("courtFileReferenceCol1: " + courtFileReferenceRepository.courtFileReference1());
        System.out.println("courtFileReferenceCol2: " + courtFileReferenceRepository.courtFileReference2());
        System.out.println("courtFileReferenceCol3: " + courtFileReferenceRepository.courtFileReference3());
        System.out.println("courtFileReferenceCol4: " + courtFileReferenceRepository.courtFileReference4());
        System.out.println("courtFileReferenceCol5: " + courtFileReferenceRepository.courtFileReference5());
        System.out.println("courtFileReferenceCol6: " + courtFileReferenceRepository.courtFileReference6());
        System.out.println("courtFileReferenceCol7: " + courtFileReferenceRepository.courtFileReference7());
        System.out.println("courtFileReferenceCol8: " + courtFileReferenceRepository.courtFileReference8());
        System.out.println("courtFileReferenceCol8: " + courtFileReferenceRepository.courtFileReference9());
        System.out.println("courtFileReferenceCol8: " + courtFileReferenceRepository.courtFileReference10());
        System.out.println("courtFileReferenceCol8: " + courtFileReferenceRepository.courtFileReference11());
        System.out.println("courtFileReferenceCol8: " + courtFileReferenceRepository.courtFileReference12());

        outerLoop:
        for (int i = 0; i <= wordsList.size(); i++) {

            for (String s1 : courtFileReferenceCol1) {
                if (s1.equalsIgnoreCase(wordsList.get(i).getWordText().toString())) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtFileReferenceColList.add(wordsList.get(i).getWordText().toString());
                }
                break;
            }
            for (String s2 : courtFileReferenceCol2) {
                if (s2.equalsIgnoreCase(wordsList.get(i).getWordText().toString())) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtFileReferenceColList.add(wordsList.get(i).getWordText().toString());

                }
                break;
            }
            for (String s2 : courtFileReferenceCol3) {
                if (s2.equalsIgnoreCase(wordsList.get(i).getWordText().toString())) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtFileReferenceColList.add(wordsList.get(i).getWordText().toString());

                }
                break;
            }
            for (String s2 : courtFileReferenceCol4) {
                if (s2.equalsIgnoreCase(wordsList.get(i).getWordText().toString())) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtFileReferenceColList.add(wordsList.get(i).getWordText().toString());

                }
                break;
            }
            for (String s2 : courtFileReferenceCol5) {
                if (s2.equalsIgnoreCase(wordsList.get(i).getWordText().toString())) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtFileReferenceColList.add(wordsList.get(i).getWordText().toString());

                }
                break;
            }
            for (String s2 : courtFileReferenceCol6) {
                if (s2.equalsIgnoreCase(wordsList.get(i).getWordText().toString())) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtFileReferenceColList.add(wordsList.get(i).getWordText().toString());

                }
                break;
            }
            for (String s2 : courtFileReferenceCol7) {
                if (s2.equalsIgnoreCase(wordsList.get(i).getWordText().toString())) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtFileReferenceColList.add(wordsList.get(i).getWordText().toString());

                }
                break;
            }
            for (String s2 : courtFileReferenceCol8) {
                if (s2.equalsIgnoreCase(wordsList.get(i).getWordText().toString())) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtFileReferenceColList.add(wordsList.get(i).getWordText().toString());

                }
                break;
            }
            for (String s2 : courtFileReferenceCol9) {
                if (s2.equalsIgnoreCase(wordsList.get(i).getWordText().toString())) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtFileReferenceColList.add(wordsList.get(i).getWordText().toString());

                }
                break;
            }
            for (String s2 : courtFileReferenceCol10) {
                if (s2.equalsIgnoreCase(wordsList.get(i).getWordText().toString())) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtFileReferenceColList.add(wordsList.get(i).getWordText().toString());

                }
                break;
            }
            for (String s2 : courtFileReferenceCol11) {
                if (s2.equalsIgnoreCase(wordsList.get(i).getWordText().toString())) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtFileReferenceColList.add(wordsList.get(i).getWordText().toString());

                }
                break;
            }
            for (String s3 : courtFileReferenceCol12) {
                if (wordsList.get(i).getWordText().toString().equalsIgnoreCase(s3)) {
                    System.out.println("ZNALAZŁEEM!!!! Słowo: " + wordsList.get(i).getWordText().toString());
                    finalCourtFileReferenceColList.add(wordsList.get(i).getWordText().toString());
                    //finalCourtDepartmentNameList.add(wordsList.get(i + 1).getWordText().toString());
                    System.out.println("Nazwa sądu to: " + finalCourtFileReferenceColList.toString());
                    break outerLoop;
                }

            }
        }

    }
}
