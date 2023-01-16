import java.io.*;
import java.util.*;

public class Personality {
    public static final int DIMENSION = 4;
    public static void main(String[] args) throws FileNotFoundException {        
        Scanner console = new Scanner(System.in);
        intro();  
        
        System.out.print("input file name? ");
        String inputName = console.nextLine();
        Scanner input = new Scanner(new File(inputName)); 
        System.out.print("output file name? ");
        String outputName = console.nextLine();
        PrintStream output = new PrintStream(new File(outputName)); 
        
        while (input.hasNextLine()) {
            output.print(input.nextLine() + ": ");  
            int[] list = counts(input); 
            int[] result = percentage(list, output);  
            String[] letters = type(result, output);  
        }
    }
    
    public static void intro() {
        System.out.println("This program processes a file of answers to the");
        System.out.println("Keirsey Temperament Sorter.  It converts the");
        System.out.println("various A and B answers for each person into");
        System.out.println("a sequence of B-percentages and then into a");
        System.out.println("four-letter personality type.");
        System.out.println();
    } 

    public static int[] counts(Scanner input) {
        int[] list = new int[DIMENSION * 2]; 
        String choice = input.nextLine();
        for (int i = 0; i < choice.length(); i++) {
            char ch = choice.charAt(i);
            if (ch == 'A' || ch == 'a') {
                list[(i % 7 + 1) / 2]++;
            } else if (ch == 'B' || ch == 'b') {
                list[(i % 7 + 1) / 2 + DIMENSION]++;
            }
        }
        return list; 
    }
    
    public static int[] percentage(int[] list, PrintStream output) {
        int[] result = new int[DIMENSION];
        for (int i = 0; i < DIMENSION; i++) {
            result[i] = (int) Math.round(100.0 * list[DIMENSION + i] / 
                (list[i] + list[DIMENSION + i]));
        }
        output.print(Arrays.toString(result) + " = ");
        return result; 
    }
    
    public static String[] type(int[] result, PrintStream output) {
        String[] letters = {"E", "I", "S", "N", "T", "F", "J", "P"};
        for (int i = 0; i < DIMENSION; i++) {
            if (result[i] < 50) {
                output.print(letters[i * 2]);
            } else if (result[i] > 50) {
                output.print(letters[i * 2 + 1]);
            } else {
                output.print("X");
            }
        }
        output.println();
        return letters; 
    }
}                                              
