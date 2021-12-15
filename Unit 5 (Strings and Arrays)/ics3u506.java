import java.io.*;
import java.util.*;

public class ics3u506 {
	public static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		String S1 = sc.nextLine(), S2 = sc.nextLine(), S3 = sc.nextLine();
		String pass = "" + S1.toUpperCase().charAt(0) + S2.toUpperCase().charAt(0) + S3.toUpperCase().charAt(0);
		pass += Integer.toString(Math.abs(S1.length() - S2.length()));
		String add = "#"; for (int i = 0; i < Math.min(10, S1.length()) && add.equals("#"); i += 2) if (S1.charAt(i) == 'a') add = Integer.toString(i);
		pass += add;
		S3 = S3.replace(" ", "").toLowerCase();
		for (int i = Math.max(0, S3.length() - 3); i < S3.length(); i++) pass += S3.charAt(i);
		while (pass.length() < 8) pass += "%";  
		System.out.println(pass);
	}
}
