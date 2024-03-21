/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
/**
 *
 * @author thanos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // Loading dictionary from URL
        Set<String> dictionary = loadDictionary("https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt");

        // Finding 9 letters words 
        List<String> validWords = findValidWords(dictionary);

        // Results start here
        System.out.println("Валидни думи:");

        for (String word : validWords) {
            List<String> intermediateWords = reduceToAI(word, dictionary);
            if (!intermediateWords.isEmpty()) {
                System.out.println("Дума: " + word);
                System.out.println("Възможни думи:");
                for (String intermediateWord : intermediateWords) {
                    System.out.println(intermediateWord);
                }
            } else {
                System.out.println("Началната дума не съдържа 'A' или 'I': " + word);
            }
        }
    }

    // Loading dictionary from URL
    private static Set<String> loadDictionary(String urlString) throws IOException {
        Set<String> dictionary = new HashSet<>();
        URL url = new URL(urlString);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dictionary.add(line.trim());
            }
        }
        return dictionary;
    }

    // Finding 9 letters words 
    private static List<String> findValidWords(Set<String> dictionary) {
        List<String> validWords = new ArrayList<>();
        for (String word : dictionary) {
            if (word.length() == 9) {
                validWords.add(word);
            }
        }
        return validWords;
    }

    public static List<String> reduceToAI(String input, Set<String> dictionary) {
        // Check if the initial word contains 'A' or 'I'
        if (!containsAorI(input)) {
            return new ArrayList<>();
        }

        StringBuilder stringBuilder = new StringBuilder(input);
        List<String> intermediateWords = new ArrayList<>();

        // Add the initial word
        intermediateWords.add(stringBuilder.toString());

        // Iterate until the string contains only 'A' or 'I'
        while (stringBuilder.length() > 1 && !isOnlyAI(stringBuilder.toString())) {
            // Choose a random index to remove a character
            int indexToRemove = (int) (Math.random() * stringBuilder.length());
            // Remove the character at the chosen index
            stringBuilder.deleteCharAt(indexToRemove);
            // Check if the reduced word is a valid word in the dictionary
            String reducedWord = stringBuilder.toString();
            if (dictionary.contains(reducedWord)) {
                intermediateWords.add(reducedWord);
            }
        }

        // If the final word is a single character and not 'I', change it to 'I'
        if (stringBuilder.length() == 1 && !stringBuilder.toString().equals("I")) {
            stringBuilder.setCharAt(0, 'I');
            intermediateWords.add(stringBuilder.toString());
        } else if (stringBuilder.length() > 1 && !stringBuilder.toString().contains("I")) {
            // Remove the final word if it doesn't contain 'I'
            intermediateWords.remove(intermediateWords.size() - 1);
        }

        return intermediateWords;
    }

    public static boolean isOnlyAI(String str) {
        // Check if the string contains only 'A' or 'I'
        for (char c : str.toCharArray()) {
            if (c != 'A' && c != 'I') {
                return false;
            }
        }
        return true;
    }

    public static boolean containsAorI(String str) {
        // Check if the string contains 'A' or 'I'
        return str.contains("A") || str.contains("I");
    }
}