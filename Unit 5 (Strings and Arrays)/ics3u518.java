import java.io.*;
import java.util.*;

public class ics3u518 {
	public static final Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		String S = sc.nextLine();
		int ans = 1;
		for (int i = 0; i < S.length(); i++) {
			String curr = Character.toString(S.charAt(i));
			for (int j = i + 1; j < S.length(); j++) {
				curr += Character.toString(S.charAt(j));
				if (curr.equals(reverse(curr))) ans = Math.max(ans, curr.length());
			}
		}
		System.out.println(ans);	
	}
	public static String reverse(String S) {
		String ret = ""; for (int i = S.length() - 1; i >= 0; i--) ret += S.charAt(i);
		return ret;
	}
}
