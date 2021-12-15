import java.io.*;
import java.util.*;

public class ics3u508 {
	public static final Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		System.out.println(count(sc.nextLine().toUpperCase().charAt(0), sc.nextLine().toUpperCase()));
	}
	public static int count (char c, String S) {
		int ret = 0; for (int i = 0; i < S.length(); i++) if (S.charAt(i) == c) ++ret;
		return ret;
	}
}
