import java.io.*;
import java.util.*;

public class  ics3u307 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;
		while (N <= 0) {
			System.out.println("Enter a positive integer:");
			N = sc.nextInt();
		}
		int tot = 0;
		for (int i = 0; i < Integer.toString(N).length(); i++) tot += Integer.toString(N).charAt(i) - '0';
		System.out.println("Sum of " + N + "'s digits is " + tot);	
	}
}
