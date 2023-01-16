// Xinghan GUO
// 10/21/2019
// This program prompts a person for income and expense amounts, 
// then calculates their net monthly income and compares them.

import java.util.*;

// Define the class constant (for the days in a month) as 31.
public class Budgeter {
    public static final int DAYS = 31;
    
    // There are five parts inside the main,
    // which are composed of introduction, the amount of income and expense users input,
    // the choice of monthly or daily expense to calculate,
    // and the results.     
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        intro();
        double totIncome = amount(console, "income");
        int pattern = monthOrDay(console);
        double totExpense = amount(console, "expense");
        printResults(totIncome, totExpense, pattern);
        }
    
    // Print out an introduction to the program.
    public static void intro() {
        System.out.println("This program asks for your monthly income and");
        System.out.println("expenses, then tells you your net monthly income.");
        System.out.println();
    }
    
    // Read in the categories and amounts of income or expenses
    public static double amount(Scanner console, String inOrEx) {
        System.out.print("How many categories of " + inOrEx + "? ");
        int categories = console.nextInt();
     
        double totAmount = 0.0;
        for (int i = 1; i <= categories; i++) {
            System.out.print("    Next " + inOrEx + " amount? $");
            double num = console.nextDouble();
            totAmount += num;
        }
        System.out.println();
        
        return totAmount;
    }
    
    // Read in the pattern of expenses calculation by monthly or daily 
    public static int monthOrDay(Scanner console) {
        System.out.print("Enter 1) monthly or 2) daily expenses? ");
        int pattern = console.nextInt();
        
        return pattern;
    }     
    
    // Compute and print the results of total incomes and expenses,
    // then compare them to make decisions about users' habits.
    // Finally, print the suggestion message about the habits. 
    public static void printResults(double totIncome, double totExpense, int pattern) {
        double aveIncome = totIncome / DAYS;
        System.out.print("Total income = $" + round(totIncome));
        System.out.println(" ($" + round(aveIncome) + "/day)");
        
        if (pattern == 1) {
            totExpense = totExpense;
        } else {
            totExpense = totExpense * DAYS;
        }
 
        double aveExpense = totExpense / DAYS;
        System.out.print("Total expenses = $" + round(totExpense));
        System.out.println(" ($" + round(aveExpense) + "/day)");
        
        System.out.println();
        
        double net = totIncome - totExpense;
        if (net > 0) {
            System.out.println("You earned $" + round(net) + " more than you spent this month.");
            if (net > 250) {
                System.out.println("You're a big saver.");
                System.out.println("You can spend more money next month.");
            } else {
                System.out.println("You're a saver.");
                System.out.println("You should keep this great habit.");
            }
        } else {
            System.out.print("You spent $" + round(Math.abs(net)));
            System.out.println(" more than you earned this month.");
            if (net > -250) {
                System.out.println("You're a spender.");
                System.out.println("You should spend less money in the next month.");
            } else {
                System.out.println("You're a big spender.");
                System.out.println("You have to cut off much more expense in the future.");
            }
        }   
    }
    
    // Return the given number rounded to two decimal places.
    public static double round(double num) {
        return Math.round(num * 100.0) / 100.0;
    }
}
