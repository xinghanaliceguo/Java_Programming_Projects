// Xinghan Guo
// A LetterInventory keeps track of an inventory of letters of the alphabet.

public class LetterInventory {
    private int[] elementData; // list of count of each alphabetic charater;
    private int size; // current sum of all counts in the list
    
    public static final int COUNTERS = 26;
    
    // post: construct an empty list with given COUNTERS,
    //       then compute the count of each alphabetic character(ignoring the case)
    //       of given string at given index in the list
    public LetterInventory(String data) {
        elementData = new int[COUNTERS];
        size = 0;
        data = data.toLowerCase();
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                elementData[ch - 'a']++;
                size++;
            }
        }
    }
    
    // post: returns the currrent sum of all counts in the list
    public int size() {
        return size;
    }
    
    // post: returns ture if all counts are 0 in the list, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }
    
    // pre: 'a' <= letter(ignoring case) <= 'z' (throws IllegalArgumentException if not)
    // post: returns the count of given letter at the given index in the list
    public int get(char letter) {
        letter = Character.toLowerCase(letter);
        if (letter >= 'a' && letter <= 'z') {
            return elementData[letter - 'a'];
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    // post: creates a lowercase, sorted order and square bracketed version of the list
    public String toString() {
        String result = "[";
        for (int i = 0; i < COUNTERS; i++) {
            for (int j = 1; j <= elementData[i]; j++) {
                result += (char) ('a' + i);
            }
        }
        return result + "]";
    }
    
    // pre: 'a' <= letter(ignoring case) <= 'z', and value >= 0
    //      (throws IllegalArgumentException if not)
    // post: set the given value as a new count for given letter in the list,
    //       change size depending on the difference between value and the original count
    public void set(char letter, int value) {
        letter = Character.toLowerCase(letter);
        if (letter < 'a' || letter > 'z' || value < 0) {
            throw new IllegalArgumentException();
        } else {
            size -= elementData[letter - 'a'];
            size += value;
            elementData[letter - 'a'] = value;
        }
    }
    
    // post: constructs a new LetterInventory with empty string,
    //       the value in each index is the sum of the count of
    //       this LetterInventory and other given LetterInventory at the given index,
    //       returns the new inventory with added counts
    public LetterInventory add(LetterInventory other) {
        LetterInventory sum = new LetterInventory("");
        for (int i = 0; i < COUNTERS; i++) {
            sum.elementData[i] = this.elementData[i] + other.elementData[i];
        }
        sum.size = this.size + other.size;
        return sum;
    }
    
    // post: constructs a new LetterInventory with empty string,
    //       the value in each index is the count of this LetterInventory
    //       minus that of other given LetterInventory at given index
    //
    //       returns null if any resulting count is negative,
    //       otherwise returns the new inventory with subtracted counts
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory list = new LetterInventory("");
        for (int i = 0; i < COUNTERS; i++) {
            list.elementData[i] = this.elementData[i] - other.elementData[i];
            if (list.elementData[i] < 0) {
                return null;
            }
        }
        list.size = this.size - other.size;
        return list;
    }
}
