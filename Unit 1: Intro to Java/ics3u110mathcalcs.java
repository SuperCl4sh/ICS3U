import java.io.*;
import java.util.*;

public class ics3u110mathcalcs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Square Root");
		System.out.println("Input a positive number:");
		int sqrtNum = sc.nextInt();
		System.out.println("The square root of " + sqrtNum + " is " + Math.sqrt(sqrtNum));

		System.out.println("\n****\n");
		
		System.out.println("Exponents");
		System.out.println("Input an integer:");
		int X = sc.nextInt();
		System.out.println("Input a second integer:");
		int Y = sc.nextInt();
		System.out.println(X + " to the power of " + Y + " is: " + Math.pow(X, Y));

		System.out.println("\n****\n");

		System.out.println("Rounding, Ceiling and Floor");
		System.out.println("Input a decimal value:");
		double decVal = sc.nextDouble();
		System.out.println(decVal + " rounds to " + Math.round(decVal));
		System.out.println(decVal + " ceiling is " + Math.ceil(decVal) + "  ");
		System.out.println(decVal + " floor is " + Math.floor(decVal));

		System.out.println("\n****\n");

		System.out.println("Random");
		System.out.println("Enter the lower limit:");
		int low = sc.nextInt();
		System.out.println("Enter the upper limit:");
		int high = sc.nextInt();
		System.out.println("A random number between " + low + " and " + high + " is 6.0");
	}
}
