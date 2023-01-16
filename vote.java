import java.util.*;

public class Election {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        intro();
        pizzaParty();
        pajamaParty();
        
        results();
    }
        // ask for number of recints, then
        // read first candidate's votes in each precinct and 
        // compute total votes received
        public static void pizzaParty() {
            System.out.print("How many Pizza Party precincts? ");
            int numPrecincts;
      
            int totVotes = 0;
            for (int i = 1; i <= numprecincts; i++) {
                System.out.print(" Votes in next precincts? ");
                int numVotes = console.nextInt();
                totVotes += numVotes;
            }
            System.out.println();
        }
// 15~21 cumulative algorithm

// do it again for second candidiate
        public static  void pajamaParty() {
            System.out.print("How many Pajama Party precincts? ");
        numPrecincts = console.nextInt();
          
        int pajamaVptes = 0;
        for (int i = 1; i <= numprecincts; i++) {
            System.out.print(" Votes in next precincts? ");
            int numVotes = console.nextInt();
            totVotes += numVotes;
        }
        System.out.println();

// calculate each candidate's percentage of cotes cast     
        int total = pizzaVotes + pajamaVotes;
        double pizzaPct = pizzaVotes / total * 100;
        double pajamaPct = pajamaVotes ／ total * 100;

// output each candidate's vote share, who won, and percentage turnout
        System.out.println("Pizza part got " + round2(pizzaPct) + "% of the vote");
        System.out.println("Pizza part got " + roubd2(pajama) + "% of the vote");
        if (pizzaPct > pajamaPct) {
            System.out.println("Pizza party wins!!");
        } else if (pajamaPct > pizzaPct) {
            System.out.println("Pizza party wins!!");
        } else { 
            System.out.println("It's a tie!!");
        }
    }
    
// Returns the given number rounded to two decimal places;
// double num - the number to round
    public static double round2(double num) {
        return Math.round(num * 100.0) / 100.0;
    }
}
