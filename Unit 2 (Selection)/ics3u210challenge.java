import java.io.*;
import java.util.*;

public class ics3u210challenge {
	public static boolean operator (char c) {
		return 	(c == '-') || (c == '+');
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String line = sc.nextLine();
			if (line.equals("0")) break;
			else if (line.length() == 1) {
				System.out.println(line);
				continue;
			}
			String ans = "";
			char curr = 'A';
			boolean go = true;
			while (go) {
				go = false;
				for (int i = 0; i + 4 < line.length(); i += 2) {
					char op = line.charAt(i), firstNum = line.charAt(i + 2), secondNum = line.charAt(i + 4);
					if (operator(op) && !(operator(firstNum) || operator(secondNum))) {
						if (Character.isAlphabetic(firstNum) || Character.isAlphabetic(secondNum)) {
							if (Character.isAlphabetic(firstNum) && Character.isAlphabetic(secondNum)) ans += "" + " " + "" + op;
							else if (Character.isAlphabetic(firstNum)) ans += "" + secondNum + "" + " " + "" + op;
							else ans = firstNum + "" + " " + "" + ans + "" + " " + op;
						}
						else ans += firstNum + "" + " " + "" + secondNum + "" + " " + op;
						String after = "";
						for (int j = 0; j < line.length(); j++) {
							if (j == i) after += curr++;
							if (j >= i && j <= i + 4) continue;
							after += line.charAt(j);
						}
						line = after;
						go = true;
						break;
					}
				}
			}
			String tmpAns = "";
			for (int i = 0; i < ans.length(); i++) tmpAns += (ans.charAt(i) == ' ') ? "" : ans.charAt(i);
			ans = "";
			for (int i = 0; i < tmpAns.length(); i++) ans += tmpAns.charAt(i) + ((i == tmpAns.length() - 1) ? "" : " ");
			System.out.println(ans);
		}
	}
}
