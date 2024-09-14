package org.example.challenge.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ChallengeOne {

    public static void main(String[] args) {
        //System.out.println(countSpacesOne("Test of count spaces"));
        //System.out.println(countSpacesTwo("Test of count spaces"));
        //System.out.println(wordReverseOne("Hello world!"));
        //System.out.println(wordReverseTwo("Hello world!"));
        //System.out.println(sentenceReverseOne("La pelota se cayó"));
        //System.out.println(sentenceReverseTwo("La pelota se cayó"));
        System.out.println(findTheWord("Hello world! This is a test", "test"));
        System.out.println(findThePositionOfWord("Hello world! This is a test", "test"));
    }

    static int countSpacesOne(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (String.valueOf(word.charAt(i)).equalsIgnoreCase(" ")){
                count ++;
            }
        }
        return count;
    }

    static int countSpacesTwo(String word){
        int count = 0;
        count = word.split(" ").length-1;
        return count;
    }

    static String wordReverseOne(String word) {
        String[] words = word.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }
        return reversed.toString().trim();
    }

    static String wordReverseTwo(String word) {
        String[] words = word.split(" ");
        String finalWord = "";
        for(int i = words.length - 1; i >= 0; i--) {
            finalWord = finalWord + words[i] + " ";
        }
        return finalWord.trim();
    }

    static String sentenceReverseOne(String word){
        String sentenceFinal = "";
        String[] sentenceArray = new String[word.length()];
        for (int i = word.length() - 1; i >= 0; i--) {
            sentenceFinal += String.valueOf(word.charAt(i));
        }
        return sentenceFinal;
    }

    static String sentenceReverseTwo(String word){
        // other way to reverse a sentence
        return new StringBuilder(word).reverse().toString();
    }

    static String findTheWord(String word, String wordToFind){
        String[] words = word.split(" ");
        for (String w : words) {
            if (w.equalsIgnoreCase(wordToFind)){
                return w;
            }
        }
        return "Word not found";
    }

    static String findThePositionOfWord(String word, String wordToFind){
        String[] words = word.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(wordToFind)){
                return "The word is in the position: " + (i + 1);
            }
        }
        return "Word not found";
    }

    //Partitions list into sublists of size n
    static <T> List<List<T>> partition(List<T> list, int n) {
        List<List<T>> partitions = new java.util.ArrayList<>();
        for (int i = 0; i < list.size(); i += n) {
            partitions.add(list.subList(i, Math.min(i + n, list.size())));
        }
        return partitions;
    }

    //Partitions 20000 rows into sublists of size 5000
    static <T> List<List<T>> partitionTwo(List<T> list) {
        //other way to partition a list
        Map<Integer, List<T>> partitioned = list.stream()
                .collect(Collectors.groupingBy(it -> list.indexOf(it) / 5000));
        return new ArrayList<>(partitioned.values());
    }

    //Partitions 20000 rows into sublists of size 5000
    static <T> List<List<T>> partitionTree(List<T> list) {
        //other way to partition a list
        TreeMap<Integer, List<T>> partitioned = list.stream()
                .collect(Collectors.groupingBy(it -> list.indexOf(it) / 5000, TreeMap::new, Collectors.toList()));
        return new ArrayList<>(partitioned.values());
    }

}
