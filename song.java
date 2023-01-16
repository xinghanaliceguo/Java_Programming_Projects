//Xinghan GUO
//9/29/2019
//This program will produce as output a cumulative song.
public class Song{
    public static void main(String[] args){
    firstVerse();
    System.out.println();
    secondVerse();
    System.out.println();
    thirdVerse();
    System.out.println();
    fourthVerse();
    System.out.println(); 
    fifthVerse(); 
    System.out.println(); 
    sixthVerse();
    System.out.println();
    seventhVerse();
    }
    
    public static void firstVerse(){
    System.out.println("There was an old woman who swallowed a fly.");
    line1();
    }
    
    public static void secondVerse(){
    System.out.println("There was an old woman who swallowed a spider,");
    System.out.println("That wriggled and iggled and jiggled inside her.");
    line2();
    }
    
    public static void thirdVerse(){
    System.out.println("There was an old woman who swallowed a bird,");
    System.out.println("How absurd to swallow a bird.");
    line3();
    } 
    
    public static void fourthVerse(){ 
    System.out.println("There was an old woman who swallowed a cat,");
    System.out.println("Imagine that to swallow a cat.");
    line4();
    }
    
    public static void fifthVerse(){
    System.out.println("There was an old woman who swallowed a dog,");
    System.out.println("What a hog to swallow a dog.");
    line5();
    }
    
    public static void sixthVerse(){
    System.out.println("There was an old woman who swallowed a fox,");
    System.out.println("Such a crazy woman to swallow a fox.");
    System.out.println("She swallowed the fox to catch the dog,");
    line5();
    }
    
    public static void seventhVerse(){
    System.out.println("There was an old woman who swallowed a horse,");
    System.out.println("She died of course.");
    }
    
    public static void line1(){
    System.out.println("I don't know why she swallowed that fly,");
    System.out.println("Perhaps she'll die.");
    }
    
    public static void line2(){
    System.out.println("She swallowed the spider to catch the fly,");
    line1();
    }
    
    public static void line3(){
    System.out.println("She swallowed the bird to catch the spider,");
    line2();
    }
    
    public static void line4(){
    System.out.println("She swallowed the cat to catch the bird,");
    line3();
    }
    
    public static void line5(){
    System.out.println("She swallowed the dog to catch the cat,");
    line4();
    }   
}
