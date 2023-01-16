// Xinghan GUO
// 10/28/2019 
// This program allows the user to play a game in which the program thinks of a random integer 
// and accepts guesses from the user until the user guesses the number correctly. 

import java.util.*;

// Define the class constant (for the range of number) as 100
public class GuessingGame {
    public static final int RANGE = 100;

// There are three methods in main mothods, including introduction,
// play one game, and print results.
// Also, asking use whether continue or stop and playing multiple games in main.      
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random(159);
       
        int totGuesses = 0;
        int games = 0;
        int bestGame = 1000000; 
        boolean start = true;

        intro();               

// Using for loop to decide when to stop playing game.       
        while (start) {
            int guess = playOneGame(console, rand);
            
// Record and save the number of total guesses
            totGuesses += guess;
            games++;
            
// Using Math.min to compare the guess between new and last games
            bestGame = Math.min(guess, bestGame);
            
            System.out.print("Do you want to play again? ");
            
// Boolean return true when the answer word starts with "y" or "Y"
            String choice = console.next();
            start = choice.startsWith("y") || choice.startsWith("Y");
            System.out.println();    
        }
           
        printResults(games, totGuesses, bestGame); 
    }
    
// Print out an introduction to the program 
    public static void intro() {
        System.out.println("This is a fun game.");
        System.out.println("Guess number after each hint.");
        System.out.println("You can start it now.");
        System.out.println();
    }

// Play one game with the user. 
    public static int playOneGame(Scanner console, Random rand) {
        System.out.println("I'm thinking of a number between 1 and " + RANGE + "...");
        
        int answer = rand.nextInt(RANGE) + 1;
        int num = 0;
        int guess = 0;
        
// Use the while loop. When the number user guess equals to the expected number, 
// stop operate in loop.
        while (num != answer) {
            System.out.print("Your guess? ");
            num = console.nextInt();
            
// Use if/else statement to give hints for users. 
// user can redefine the range and guess by knowing that the number is lower or higher.
            if (num > answer) {
                System.out.println("It's lower.");
            } else if (num < answer) {
                System.out.println("It's higher.");
            }
            
// Everytime user guesses, the number of guess in a game adds one.
            guess++;    
        }
        
// Use if/else statement to make sure the correctness of singular and prural word
        System.out.print("You got it right in " + guess);
        if (guess == 1) {
            System.out.println(" guess!");
        } else {
            System.out.println(" guesses!");
        }
        
// The number of guesses in one game can be received.
        return guess;     
    }

// Print out the final results
// about the parameter: games- number of games; totGuesses- the number of total guesses;
// bestGame: the number of guesses in the best game.    
    public static void printResults(int games, int totGuesses, int bestGame) {
        System.out.println("Overall results:");
        System.out.println("Total games   = " + games);
        System.out.println("Total guesses = " + totGuesses);
        System.out.println("Guesses/game  = " + round1((double)totGuesses / games));
        System.out.println("Best game     = " + bestGame);
    }

// Return the given number rounded to one decimal places. 
    public static double round1(double num) {
    
// The number rounded can be received    
        return Math.round(num * 10.0) / 10.0;
    }

}
