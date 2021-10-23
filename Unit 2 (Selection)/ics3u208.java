import java.io.*;
import java.util.*;

public class ics3u208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter amount less than $1");
		int cents = sc.nextInt();
		int quarters = (int)(cents / 25);
		cents %= 25;
		int dimes = (int)(cents / 10);
		cents %= 10;
		int nickels = (int)(cents / 5);
		cents %= 5;
		int pennies = cents;

		System.out.println("Your change is:");
		if (quarters > 0) System.out.println(quarters + " quarter" + ((quarters > 1) ? "s" : ""));
		if (dimes > 0) System.out.println(dimes + " dime" + ((dimes > 1) ? "s" : ""));
		if (nickels > 0) System.out.println(nickels + " nickel" + ((nickels > 1) ? "s" : ""));
		if (pennies > 0) System.out.println(pennies + " " + ((pennies > 1) ? "pennies" : "penny"));
	}
}
