import java.io.*;
import java.util.*;

public class ics3u200 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number:");
		int firstNum = sc.nextInt();
		System.out.println("Enter second number:");
		int secondNum = sc.nextInt();
		System.out.println("Result: " + ((firstNum == secondNum) ? "The numbers are equal" : Math.max(firstNum, secondNum) + " is larger than " + Math.min(firstNum, secondNum)));
	}
}

