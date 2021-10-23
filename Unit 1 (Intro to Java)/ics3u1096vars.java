import java.io.*;
import java.util.*;

public class ics3u1096vars {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Where were you born?  Enter a string value:");
		String city = sc.nextLine();
		System.out.println("What is your middle initial? Enter a character:");
		char initial = sc.nextLine().charAt(0);
		System.out.println("What year were you born?  Enter the 4 digit integer value:");
		int year = sc.nextInt();
		System.out.println("Pick a number between 16 and 17.  Enter the decimal number:");
		double num = sc.nextDouble();
		System.out.println("Thank you for your input.");
		System.out.println(city + " is beautiful.");
		System.out.println(initial + ", can I call you, \"" + initial + "\" - I think you must be " + year + " + " + num + " years old and attend \"Colonel By\".");
	}
}
