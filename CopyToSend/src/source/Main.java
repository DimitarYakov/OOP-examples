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
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *
 * @author thanos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static boolean isChecked = false;
    
    public static void main(String[] args) throws IOException {
        Set<String> dictionary = loadDictionary("https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt");

        // Finding 9 letters words 
        List<String> words = findNineLetterWords(dictionary);
        int count = 0;
        for (String word : words) {
            removeCharacters(word,dictionary);
            count++;
        }
        System.out.println("9 letters words count: " + count);
    }

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

    public static List<String> findNineLetterWords(Set<String> dictionary) {
        List<String> nineLetterWords = new ArrayList<>();
        for (String word : dictionary) {
            if (word.length() == 9 && (word.contains("A") || word.contains("I"))) {
                nineLetterWords.add(word);
            }
        }
        return nineLetterWords;
    }
    
    public static String removeCharacters(String word, Set<String> dictionary) {
        System.out.println(word);
        
        char[] characters = word.toCharArray();
        boolean found = false;
        
        for (int i = 0; i < characters.length; i++) {
            if ((characters[i] == 'A' || characters[i] == 'I') && !found) {
                found = true;
                System.out.println("Found a valid single letter " + characters[i]);
            }
            else {
                characters[i] = '\0'; 
                System.out.print("Remove the " + characters[i] + ", and the word becomes: ");
            }
            
            String checkerStr = Arrays.toString(characters);
            
            if(dictionary.contains(checkerStr)){
                isChecked = true;
            }
            else{
                isChecked = false;
            }
            System.out.println(Arrays.toString(characters) + " " + isChecked);
            
            StringBuilder result = new StringBuilder();
            for (char ch : characters) {
                if (ch != '\0') {
                    result.append(ch);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : characters) {
            if (ch != '\0') {
                result.append(ch);
            }
        }

        return result.toString();
    }
}