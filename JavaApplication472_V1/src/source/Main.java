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
import java.util.*;
/**
 *
 * @author thanos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static String message = " is not a valid single word";
    public static boolean checker = false;
    
    public static void main(String[] args) throws IOException {
        Set<String> dictionary = loadDictionary("https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt");

        List<String> words = findNineLetterWords(dictionary);
        int count= 0;
        for(String word:words){
            count++;
            removeLettersUntilOneLeft(word, dictionary);
        }
        System.out.println(count);
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
    
    public static void removeLettersUntilOneLeft(String word, Set<String> dictionary) {
        System.out.println(word); 
        
        Random random = new Random();
        
        while (word.length() > 1) {
            int position = random.nextInt(word.length());
            char removedLetter = word.charAt(position);
            word = removeLetterAtPosition(word, position);
            if(dictionary.contains(word)){
                checker = true;
            }
            else{
                checker = false;
            }
            System.out.println("Remove " + removedLetter + " :" + word + " " + checker);
            if (word.length() == 1 && !(word.equalsIgnoreCase("A") || word.equalsIgnoreCase("I"))) { 
                word += message;
                break;
            }
            
            
        }
        
        System.out.println("Останала буква: " + word);
    }
    
    public static String removeLetterAtPosition(String word, int position) {
        if (position < 0 || position >= word.length()) {
            return word; 
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i != position) {
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }
}