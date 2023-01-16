// Xinghan Guo
// A QuestionTree class keeps track of a binary tree and asks questions depending on each
// time the user responses "yes" or "no", until the computer guesses the final answer.

import java.io.*;
import java.util.*;

public class QuestionTree {
    private QuestionNode overallRoot; // current tree of questions and answers
    private Scanner console; // reads in what user says
    
    // post: creates a question tree with one node representing "computer"
    public QuestionTree() {
        overallRoot = new QuestionNode("computer");
        console = new Scanner(System.in);
    }
    
    // post: replaces current tree with a new tree by reading in the informtion of given input file
    public void read(Scanner input) {
        overallRoot = read(overallRoot, input);
    }
    
    // post: replaces with a question tree or answer tree if the text in given line of 
    //       given input file is symbolized by "Q" or "A", and recursively replaces at 
    //       every subtree of question node until reaching the answer node;  
    //       updates each round and returns current tree
    private QuestionNode read(QuestionNode root, Scanner input) {
        if (input.nextLine().equals("Q:")) {
            root = new QuestionNode(input.nextLine(), read(root, input), read(root, input));
        } else {
            root = new QuestionNode(input.nextLine());
        }
        return root;
    }
    
    // post: prints and stores current information of tree into given output file
    public void write(PrintStream output) {
        write(overallRoot, output);
    }
    
    // post: prints and stores current information of given root into given output file
    private void write(QuestionNode root, PrintStream output) {
        if (root.left == null) {
            output.println("A:");
            output.println(root.data);
        } else {
            output.println("Q:");
            output.println(root.data);
            write(root.left, output);
            write(root.right, output);
        }
    }
    
    // post: asks the user questions and finds the final answer.
    public void askQuestions() {
        overallRoot = askQuestions(overallRoot);
    }
    
    // post: asks the user questions according to the information in given root recursively
    //       until finding the final answer(reaching answer node);
    //       updates each round and returns current tree
    private QuestionNode askQuestions(QuestionNode root) {
        if (root.left == null) {
            root = answerNode(root);
        } else {
            if (yesTo(root.data)) {
                root.left = askQuestions(root.left);
            } else {
                root.right = askQuestions(root.right);
            }
        }
        return root;
    }
    
    // post: After guessing final anwer(reaching anwer node), if not correct, 
    //       asks the user true answer and new questions used for distinguish from 
    //       other information, then adds these new information into given root; 
    //       updates each round and returns current tree 
    private QuestionNode answerNode(QuestionNode root) {
        if (yesTo("Would your object happen to be " + root.data + "?")) {
            System.out.println("Great, I got it right!");
        } else {
            System.out.print("What is the name of your object? ");
            QuestionNode trueAnswer = new QuestionNode(console.nextLine());
            System.out.println("Please give me a yes/no question that");
            System.out.println("distinguishes between your object");
            System.out.print("and mine--> ");
            String newQuestion = console.nextLine();
            if (yesTo("And what is the answer for your object?")) {
                root = new QuestionNode(newQuestion, trueAnswer, root);
            } else {
                root = new QuestionNode(newQuestion, root, trueAnswer);
            }
        }
        return root;
    }
    
    // post: asks the user a question, forcing an answer of "y " or "n";
    // returns true if the answer was yes, returns false otherwise
    public boolean yesTo(String prompt) {
        System.out.print(prompt + " (y/n)? ");
        String response = console.nextLine().trim().toLowerCase();
        while (!response.equals("y") && !response.equals("n")) {
            System.out.println("Please answer y or n.");
            System.out.print(prompt + " (y/n)? ");
            response = console.nextLine().trim().toLowerCase();
        }
        return response.equals("y");
    }
}
