/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/**
 *
 * @author thanos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static final String WORDS_URL = "https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt";
    private static final HashSet<String> validWordsSet = new HashSet<>();

    public static void loadWordsFromURL(String url) throws Exception {
        URL wordListURL = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListURL.openStream()));
        String word;
        while ((word = in.readLine()) != null) {
            validWordsSet.add(word.trim().toLowerCase());
        }
        in.close();
    }

    public static HashSet<String> findValidNineLetterWords() {
        HashSet<String> nineLetterWords = new HashSet<>();
        for (String word : validWordsSet) {
            if (word.length() == 9 && canReduceToSingleLetter(word, 8)) {
                nineLetterWords.add(word);
            }
        }
        return nineLetterWords;
    }

    public static boolean canReduceToSingleLetter(String word, int index) {
        if (index == 0) {
            return isValidWord(word.substring(0, index));
        }
        if (isValidWord(word.substring(0, index))) {
            return true;
        }
        return canReduceToSingleLetter(word, index - 1);
    }

    public static boolean isValidWord(String word) {
        return validWordsSet.contains(word);
    }

    public static void main(String[] args) {
        try {
            loadWordsFromURL(WORDS_URL);
            HashSet<String> nineLetterWords = findValidNineLetterWords();
            int count = 0;
            for (String word : nineLetterWords) {
                count++;
                System.out.println(count + " -> " + word);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
