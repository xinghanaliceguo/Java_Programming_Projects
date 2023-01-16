// Xinghan Guo
// A HuffmanNode class is used for a single node of a binary tree of Integers.
// It implements the Comparable interface, ordering characters by their frequencies.

public class MyNode implements Comparable<HuffmanNode> {
    public int character; // interger value of character
    public int frequency; // the number of occurances the character appears
    public HuffmanNode left; // subtree of 0's
    public HuffmanNode right; // subtree of 1's
    
    // constructs a leaf node with given character and frequency
    public HuffmanNode(int character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }
    
    // Constructs a branch node with given frequency, left 0's node, and right 1's node
    public HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
    
    // computes and compares frequency of this node with given other's
    public final int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}
