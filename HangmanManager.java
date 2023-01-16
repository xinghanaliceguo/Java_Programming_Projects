// Xinghan Guo
// A HangmanManager class keeps track of the state of a game of hangman.

import java.util.*;

public class HangmanManager {
    private Set<String> currentWords; // set of words currently considered by game manager
    private int leftChance; // the number of chances left for player to guess wrong
    private Set<Character> letters; // set of letters that have been guessed by player
    private String currentPattern; // the current pattern displayed for player
    
    // pre: length >= 1 and max >= 0 (throw IllegalArgumentException if not)
    // post: creates a set of words including all words of given length in dictionary;
    //       initials the number of chances left to guess wrong equals the given max;
    //       creates a set of letters that have been guessed by player
    //       creates a pattern displayed as n dashes of given length with spaces between them
    public HangmanManager(Collection<String> dictionary, int length, int max) {
        if (length < 1 || max < 0) {
            throw new IllegalArgumentException();
        }
        
        currentWords = new TreeSet<String>();
        for (String word: dictionary) {
            if (word.length() == length) {
                currentWords.add(word);
            }
        }
        
        leftChance = max;
        letters = new TreeSet<Character>();
        
        currentPattern = "-";
        for (int i = 0; i < length - 1; i++) {
            currentPattern += " -";
        }
    }
    
    // post: returns current set of words contained and considered by game manager
    public Set<String> words() {
        return currentWords;
    }
    
    // post: returns current number of chances left for player to guess wrong
    public int guessesLeft() {
        return leftChance;
    }
    
    // post: returns current set of letters that have been guessed by the player
    //       (including the wrong ones)
    public Set<Character> guesses() {
        return letters;
    }
    
    // pre: currentWords is not empty (throw IllegalStateException if not)
    // post: returns the current pattern displayed with correctly guessed letter in given places
    //       and dashes in given places where the letters have not been guessed right.
    //       Also seperates each letter with spaces
    public String pattern() {
        if (currentWords.isEmpty()) {
            throw new IllegalStateException();
        }
        return currentPattern;
    }
    
    // pre: leftChance >= 1 and currentWords is not empty (throw IllegalStateException if not);
    //      Previous exception didn't happen and Set<Character> letters don't contain
    //      the given guess (throw IllegalArgumentException if not)
    // post: adds the given guess to the set of letters that have been guessed;
    //       chooses the pattern and corresponding word family as currentPattern and currentWords;
    //       updates the number of chances left for player to guess wrong;
    //       returns the number of occurrences of given guess in chosen pattern
    public int record(char guess) {
        if (leftChance < 1 || currentWords.isEmpty()) {
            throw new IllegalStateException();
        }
        if (letters.contains(guess)) {
            throw new IllegalArgumentException();
        }
        
        letters.add(guess);
        bestMatch(guess);
        
        int occurrence = 0;
        for (int i = 0; i < currentPattern.length(); i++) {
            if (currentPattern.charAt(i) == guess) {
                occurrence++;
            }
        }
        if (occurrence == 0) {
            leftChance--;
        }
        return occurrence;
    }
    
    // post: maps all kinds of patterns with given word families, and then choose one pair 
    //       containing most words (choose the pattern and corresponding word family which
    //       appear earlier if the number of the most words in two word families are equal)
    private void bestMatch (char guess) {
        Map<String, Set<String>> match = new TreeMap<String, Set<String>>();
        for (String word: currentWords) {
            String pattern = currentPattern;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == guess) {
                    pattern = pattern.substring(0, j * 2) + guess + pattern.substring(j * 2 + 1);
                }
            }
            if (!match.containsKey(pattern)) {
                match.put(pattern, new TreeSet<String>());
            }
            match.get(pattern).add(word);
        }
        
        int maxSize = 0;
        for (String eachPattern: match.keySet()) {
            if (match.get(eachPattern).size() > maxSize) {
                maxSize = match.get(eachPattern).size();
                currentPattern = eachPattern ;
                currentWords = match.get(eachPattern);
            }
        }
    }
}
