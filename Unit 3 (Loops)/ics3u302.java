import java.io.*;
import java.util.*;

public class  ics3u302 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter N:");
		int N = sc.nextInt();
		while (N < 0) {
			System.out.println("Invalid input.\nEnter N:");
			N = sc.nextInt();
		}
		System.out.println("The sum of the first " + N + " integers is " + (N * (N + 1))/2);
	}
}
