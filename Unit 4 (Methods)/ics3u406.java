import java.io.*;
import java.util.*;

public class ics3u406 {
	public static void printHollowRect(char c, int width, int height) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) System.out.print((i == 0 || i == height - 1 || j == 0 || j == width - 1) ? c : " ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c = sc.nextLine().charAt(0);
		int width = sc.nextInt(), height = sc.nextInt();
		printHollowRect(c, width, height);
	}
}
