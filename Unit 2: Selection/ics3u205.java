import java.io.*;
import java.util.*;

public class ics3u205 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first num:");
		int firstNum = sc.nextInt();
		
		System.out.println("Enter second num:");
		int secondNum = sc.nextInt();
	
		System.out.println("What is " + firstNum + " mod " + secondNum + "?");
		int ans = sc.nextInt();
		System.out.println((ans == firstNum % secondNum) ? "Congrats - correct." : "Incorrect.\nModulus returns the remainder.\n" + secondNum + " divides into " + firstNum + ", " + (int)(firstNum / secondNum) + " times and there is " + firstNum % secondNum + " leftover.\n" + firstNum + " mod " + secondNum + " is " + firstNum % secondNum + ".");  
	}
}
