import java.io.*;
import java.util.*;

public class ics3u409 {
	public static boolean isDivisible(int a, int b) {
		return a % b == 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(isDivisible(sc.nextInt(), sc.nextInt()));
	}
}
