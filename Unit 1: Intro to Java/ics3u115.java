import java.io.*;
import java.util.*;

public class ics3u115 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter cents:");
		int cents = sc.nextInt();
		int quarters = (int)(cents / 25);
		cents %= 25;
		int dimes = cents / 10;
		cents %= 10;
		int nickels = cents / 5;
		cents %= 5;
		int pennies = cents;
		System.out.println("Quarters " + quarters + ", dimes " + dimes + ", nickels " + nickels + ", pennies " + pennies);
	}
}
