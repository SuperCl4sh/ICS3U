import java.io.*;
import java.util.*;

public class ics3u504 {
	public static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		int freq[] = new int [11];
		int curr = 0, valid = 0;
		while (curr >= 0) {
			curr = sc.nextInt();
			if (0 <= curr && curr <= 10) {
				freq[curr]++;
				valid++;
			}
		}
		System.out.println("Score   #Occurrences");
		for (int i = 1; i <= 10; i++) System.out.println("" + i + ((i < 10) ? "      " : "     ") + freq[i]); 
		double tot = 0; for (int i = 1; i <= 10; i++) tot += i * freq[i];
		System.out.println("Mean: " + Math.round(10.0 * tot / (double)valid) / 10.0);
	}
}
