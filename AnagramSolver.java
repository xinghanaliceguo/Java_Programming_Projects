// Xinghan Guo
// An AnagramSolver class keeps track of dictionary, finds out and prints all combinations of words
// that have the same letters as a given phrase.


import java.util.*;

public class AnagramSolver {
    private Map<String, LetterInventory> dictInventory; // pairs of each word in dictionary
                                                        // with its letter inventory
    private List<String> dict; // list of sorted dictionary
    
    // post: computes the letter inventory of each word in the given list, and creates
    //       the combination of each word with its computed letter inventory;
    //       creates a new list of dictionary which refers to the given list
    public AnagramSolver(List<String> list) {
        dictInventory = new HashMap<>();
        dict = new ArrayList<>();
        for (String word: list) {
            dictInventory.put(word, new LetterInventory(word));
        }
        dict = list;
    }
    
    // pre: max >= 0 (throw IllegalArgumentException if not)
    // post: shortens the dictionary into relevant letters, prints all kinds of combinations that
    //       have same letters with given string, and the number of words composed is equal to
    //       the given max(no limitation of number if the given max is equal to 0)
    public void print(String s, int max) {
        if (max < 0) {
            throw new IllegalArgumentException();
        }
        LetterInventory phrase = new LetterInventory(s); //compute letter inventory of given string
        List<String> shortDict = new ArrayList<>(); // select relevant dictionary
        for (String str: dict) {
            if (phrase.subtract(dictInventory.get(str)) != null) {
                shortDict.add(str);
            }
        }
        Stack<String> combination = new Stack<>();
        explore(max, phrase, combination, shortDict);
    }
    
    // post: recursively searchs given short dictionary, finds out all possible combinations by
    //       comparing letter inventories of the given phrase and each letter. Each combination
    //       is composed of max words.(no limitation of number if given max is equal to 0)
    //       Then prints the results of all combinations.
    private void explore(int max, LetterInventory phrase, Stack<String> combination,
    List<String> shortDict) {
        if (phrase.isEmpty()) {
            System.out.println(combination);
        }
        for (String str: shortDict) {
            if (phrase.subtract(dictInventory.get(str)) != null) {
                if (max == 0 || max > combination.size()) {
                    combination.push(str);
                    explore(max, phrase.subtract(dictInventory.get(str)), combination, shortDict);
                    combination.pop();
                }
            }
        }
    }
}
