// Xinghan Guo
// An AssassinManager class manages an assassin game by keeping track of
// who is stalking whom and who has been killed.


import java.util.*;

public class AssassinManager {
    private AssassinNode kingRingFront; // list of people who are still alive
    private AssassinNode graveyardFront; // list of people who have been killed
    
    // pre: list<String> name is not empty (throw IllegalArgumentException if not)
    // post: creates a king ring(people who are alive) with given names
    public AssassinManager(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException();
        }
     //   if (kingRingFront == null) {
            for (int i = names.size() - 1; i >= 0; i--) {
                kingRingFront = new AssassinNode(names.get(i), kingRingFront);
            }
    //    }
    }
    
    // post: keeps track of who is stalking whom and prints the names according to the king ring
    public void printKillRing() {
        AssassinNode current = kingRingFront;
        String front = current.name;
        while (current.next != null) {
            System.out.println("    " + current.name + " is stalking " + current.next.name);
            current = current.next;
        }
        System.out.println("    " + current.name + " is stalking " + front);
    }
    
    // post: keeps track of who has been killed and prints the names according to the graveyard
    public void printGraveyard() {
        AssassinNode current = graveyardFront;
        while (current != null) {
            System.out.println("    " + current.name + " was killed by " + current.killer);
            current = current.next;
        }
    }
    
    // returns true if the given name(ignore the case) is one of people
    // who is still alive, false otherwise
    public boolean killRingContains(String name) {
        AssassinNode current = kingRingFront;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // returns true if the given name(ignore the case) is one of people
    // who has been killed, false otherwise
    public boolean graveyardContains(String name) {
        AssassinNode current = graveyardFront;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // returns true if there is only one person currently alive, false otherwise
    public boolean gameOver() {
        return kingRingFront.next == null;
    }
    
    // returns the person's name if there is only one person currently alive, null otherwise
    public String winner() {
        if (gameOver()) {
            return kingRingFront.name;
        }
        return null;
    }
    
    // pre: the game is not over (throw IllegalStateException if not);
    //      the kill ring contains the given name(ignore the case)
    //      (throw IllegalArgumentException if not)
    // post: removes the victim(the given name, ignore the case) from king ring and
    //       transfers it to the front of graveyard
    public void kill(String name) {
        if (gameOver()) {
            throw new IllegalStateException();
        }
        if (!killRingContains(name)) {
            throw new IllegalArgumentException();
        }
        
        AssassinNode current = kingRingFront;
        AssassinNode last = current;
        if (current.name.equalsIgnoreCase(name)) {
            kingRingFront = current.next;
            while (current.next != null) {
                current = current.next;
            }
            last.killer = current.name;
        }
        
        while (current.next != null) {
            if (current.next.name.equalsIgnoreCase(name)) {
                current.next.killer = current.name;
                last = current.next;
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        last.next = graveyardFront;
        graveyardFront = last;
    }
}
