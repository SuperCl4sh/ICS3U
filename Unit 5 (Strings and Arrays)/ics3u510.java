import java.io.*;
import java.util.*;

public class ics3u510 {
	public static final Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		String alpha = ""; for (char c = 'A'; c <= 'Z'; c++) alpha += c;
		int convert[] = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String S = sc.next();
			String ans = "";
			for (int j = 0; j < S.length() && ans.length() < 12; j++) {
				if (!Character.isLetterOrDigit(S.charAt(j))) continue;
				ans += (Character.isDigit(S.charAt(j))) ? S.charAt(j) - '0' : convert[alpha.indexOf(S.charAt(j))];
				if (ans.length() == 3 || ans.length() == 7) ans += '-';
			}
			System.out.println(ans);
		}
	}
}
