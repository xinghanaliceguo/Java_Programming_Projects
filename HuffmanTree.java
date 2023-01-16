// Xinghan Guo
// A HuffmanTree class is used for compressing text files by using coding scheme 
// based on the frequency of characters.

import java.util.*;
import java.io.*;

public class MyCode {
    private HuffmanNode overallRoot; // current node of characters
    
    // post: sorts nodes according to the frequency of each character inside the given count
    //       (less frequency has a higher priority), and adds pseudo-eof with largest integer value
    //       and 1 frequency at the end;
    //       Builds the initial coding tree using the sorted frequency 
    public HuffmanTree(int[] count) {
        PriorityQueue<HuffmanNode> list = new PriorityQueue<HuffmanNode>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {            
                list.add(new HuffmanNode(i, count[i]));
            }
        }
        list.add(new HuffmanNode(count.length, 1)); 
        while (list.size() > 1) {
            HuffmanNode left = list.poll();
            HuffmanNode right = list.poll();
            list.add(new HuffmanNode(left.frequency + right.frequency, left, right));
        }
        overallRoot = list.poll();
    }
    
    // post: writes current tree into given output code file with standard format:
    //       a line representing the integer value of character followed by a line representing 
    //       the code for the character with this interger value
    public void write(PrintStream output) {
        write(output, overallRoot, "");
    }
    
    // post: keeps track of given root, updates the given code by add "0"(going left) or "1"
    //       (going right), and then prints tree into given output code file until finding 
    //       the leaf node which has interger value of character.(print in standard
    //       format: a line representing the integer value of character followed by
    //       a line representing the code for the character with this interger value)
    private void write(PrintStream output, HuffmanNode root, String code) {
        if (root.left == null) {
            output.println(root.character);
            output.println(code);
        } else {
            write(output, root.left, code + "0");
            write(output, root.right, code + "1");
        }
    }
    
    // post: recreates the coding tree according to the given input coding file 
    //       with standard format
    public HuffmanTree(Scanner input) {
        overallRoot = new HuffmanNode(0, 0);
        while (input.hasNextLine()) {
            int n = Integer.parseInt(input.nextLine());
            String code = input.nextLine();
            overallRoot = reconstruct(n, code, overallRoot);
        }
    }
   
    // post: keeps track of given root by going left(given code updated starts with "0") or right
    //       (given code updated starts with "1") until reaching the leaf node (when code has 
    //       the length of 1), creates leaf node using given character of n;
    //       unpdates each round and returns current tree
    private HuffmanNode reconstruct(int n, String code, HuffmanNode root) {
        if (code.startsWith("0") && code.length() > 1) {
            if (root.left == null) {
                root.left = reconstruct(n, code.substring(1), new HuffmanNode(0, 0));
            } else {
                root.left = reconstruct(n, code.substring(1), root.left);
            }
            
        } else if (code.startsWith("1") && code.length() > 1) {
            if (root.right == null) {
                root.right = reconstruct(n, code.substring(1), new HuffmanNode(0, 0));
            } else {
                root.right = reconstruct(n, code.substring(1), root.right);
            }
        } else {
            if (code.startsWith("0")) {
                root.left = new HuffmanNode(n, 0);
            } else {
                root.right = new HuffmanNode(n, 0);
            }
        }
        return root;
    }
    
    // post: decodes the given input file by reading bits from given input stream and 
    //       keeps track of root until finding leaf node, writes corresponding characters into 
    //       given output file (if the integer value of character is less than eof)    
    //       The whole process stops until reaching a character with value equal to given eof
    public void decode(BitInputStream input, PrintStream output, int eof) {
        HuffmanNode original = overallRoot;
        while (original.character < eof) {
            while (original.left != null) {
                if (input.readBit() == 0) {
                    original = original.left;
                } else {
                    original = original.right;
                }
            }
            if (original.character < eof) {
                output.write(original.character);
                original = overallRoot;
            }
        }
    }
}
