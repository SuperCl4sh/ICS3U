import java.io.*;
import java.util.*;

public class  ics3u300 {
    public static boolean valid (String guess) {
	    boolean good = true;
	    for (int i = 0; i < guess.length(); i++) good &= ('0' <= guess.charAt(i) && guess.charAt(i) <= '9');
	    return good;
    }
    public static void main(String[] args) {
	        //define variables
    Scanner userInput = new Scanner(System.in);
   // System.out.println("This can result in an infinite loop - Fix it!");
   System.out.println("\nEnter your guess between 1 and 10:");
    String guess = userInput.nextLine();
    while (!valid(guess) || !(Integer.parseInt(guess)>=1 && Integer.parseInt(guess)<=10)) {
      System.out.println("Invalid guess");
      guess = userInput.nextLine();
    }
  System.out.println("Valid guess entered");
    }
}
