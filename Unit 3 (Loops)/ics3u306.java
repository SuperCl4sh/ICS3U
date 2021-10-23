import java.io.*;
import java.util.*;

public class  ics3u306 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a letter:");
		String line = sc.nextLine();
		while (!('a' <= line.charAt(0) && line.charAt(0) <= 'z' || 'A' <= line.charAt(0) && line.charAt(0) <= 'Z')) {
			System.out.println("Not a letter. Enter a letter:");
			line = sc.nextLine();
		}
		System.out.println("Done.");
	}
}
