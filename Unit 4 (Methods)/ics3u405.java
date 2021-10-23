import java.io.*;
import java.util.*;

public class ics3u405 {
	public static void printRect(char c, int width, int height) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) System.out.print(c);
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c = sc.nextLine().charAt(0);
		int width = sc.nextInt(), height = sc.nextInt();
		printRect(c, width, height);
	}
}
