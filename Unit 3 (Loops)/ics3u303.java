import java.io.*;
import java.util.*;

public class  ics3u303 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double N = 1;
		while (N > 0) {
			System.out.println("Enter a positive number (or negative number to quit):");
			N = sc.nextDouble();
			if (N <= 0) break;
			System.out.println("Square root is: " + Math.round(Math.pow(10, 3) * Math.sqrt(N)) / Math.pow(10, 3) + '\n');
		}
	}
}

