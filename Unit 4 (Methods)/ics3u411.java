import java.io.*;
import java.util.*;

public class ics3u411 {
	public static boolean isLetter(String line) {
		return line.length() == 1 && 'a' <= line.toLowerCase().charAt(0) && line.toLowerCase().charAt(0) <= 'z';
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		System.out.println(isLetter(line));
	}
}
