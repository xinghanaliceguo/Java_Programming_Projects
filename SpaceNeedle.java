// Xinghan GUO
// 10/06/2019
// This project will produce a specific text figure, which looks like Seattle's Space Needle.

public class SpaceNeedle {
    // Define the class constant as 4
    public static final int SIZE = 4;
    
    // Divide the picture into different parts in main method.
    // Especially, triangle1 includes a erect triange and a longest line.
    // This group appears twice in the output picture.(top and bottom)
    public static void main(String[] args) {
        needle();
        triangle1();
        triangle2();
        needle();
        bodyMiddle();
        triangle1();
    }
    
    // triangle1 is composed of a triangle(body1) and a line(body2).
    public static void triangle1() {
        body1();
        body2(); 
    }
    
    // Using for loop to print the top needle of the picture.
    // This part also appears at the middle.
    public static void needle() {
        for (int line = 1; line <= SIZE; line++) {
            for (int needle = 1; needle <= SIZE * 3; needle++) {
                System.out.print(" ");
            }
            System.out.println("||");
        }
    }
     
    // Using for loop to print the triangle2,
    // which looks like a inverted triangle.
    public static void triangle2() {
        for (int line = 1; line <= SIZE; line++ ) {
            for (int space_Second = 1; space_Second <= 2 * line - 2; space_Second++) {
                System.out.print(" ");
            }
            System.out.print("\\_");
            for (int slash = 1; slash <= 3 * SIZE - 2 * line + 1; slash++) {
                System.out.print("/\\");
            }
            System.out.println("_/");                    
        }
    }
    
    // Using for loop to print the Middle part of Space Needle.
    // which is the longest part in the whole picture.
    public static void bodyMiddle() {
        for (int line = 1; line <= SIZE * SIZE; line++) {
            for (int space_Three = 1; space_Three <= SIZE * 2 + 1; space_Three++) {
                System.out.print(" ");
            }
            System.out.print("|");
            for (int percent = 1; percent <= SIZE - 2; percent++) {
                System.out.print("%");
            }
            System.out.print("||");
            for (int percent = 1; percent <= SIZE - 2; percent++) {
                System.out.print("%");
            }
            System.out.println("|");
        }
    }
    
    // Using for loop to print body part1 inside triangle1, 
    // which looks like a erect triangle.
    public static void body1() {
        for (int line = 1; line <= SIZE; line++) {
            for (int space_First = 1; space_First <= 3 * SIZE - 3 * line; space_First++) {
                System.out.print(" ");
            }
            System.out.print("__/");
            for (int colon = 1; colon <= 3 * line - 3; colon++) {
                System.out.print(":");
            }
            System.out.print("||");
            for (int colon = 1; colon <= 3 * line - 3; colon++) {
                System.out.print(":");
            }
            System.out.println("\\__");
        }
    }

    // Using for loop to print the body part2 inside triangle1,
    // which is the longest line.
    public static void body2() { 
        System.out.print("|");
        for (int quotation = 1; quotation <= SIZE * 6; quotation++) {
            System.out.print("\"");
        }
        System.out.println("|");
    }  
}
            
                  
            
                
                
                
