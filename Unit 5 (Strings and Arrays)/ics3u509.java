import java.io.*;
import java.util.*;

public class ics3u509 {
	public static final Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		String A = sc.nextLine(), B = sc.nextLine(), C = sc.nextLine();
		System.out.println(replace(C, A.charAt(0), B.charAt(0)));
	}
	public static String replace(String S, char oldChar, char newChar) {
		int cnt = 0;
		String ret = "";
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == oldChar) cnt ^= 1;
			if (S.charAt(i) == oldChar && cnt == 0) ret += newChar;
			else ret += S.charAt(i);
		}	
		return ret;
	}
}
