import java.io.*;
import java.util.*;

public class ics3u111 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a positive, 4-digit number (1111 to 9999):");
		int num = sc.nextInt();
		int dig1 = num % 10, dig2 = num / 10 % 10, dig3 = num / 100 % 10, dig4 = num / 1000 % 10;
		System.out.println("The digits of " + num + " are " + dig4 + ", " + dig3 + ", " + dig2 + ", and " + dig1 + ".");
	}
}
