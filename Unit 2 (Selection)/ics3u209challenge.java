import java.io.*;
import java.util.*;

public class ics3u209challenge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		String negative = "";
		if (A < 0) {
			A *= -1;
			B *= -1;
			C *= -1;
			negative = "-";
		}
		int gcf = A;
		gcf = gcd(gcf, Math.abs(B));
		gcf = gcd(gcf, Math.abs(C));
		A /= gcf;
		B /= gcf;
		C /= gcf;
		if (C == 0) {
			System.out.println(negative + ((gcf == 1) ? "" : gcf) + "x(" + ((A == 1) ? "" : A) + "x" + ((B < 0) ? "-" : "+") + Math.abs(B) + ")");
			return;
		}
		//(ax + b)(cx + d)
		final int STOP = 30;
		int a = -1, b = -1, c = -1, d = -1;
		boolean found = false;
		for (a = 1; a <= STOP; a++) {
			for (b = -STOP; b <= STOP; b++) {
				for (c = 1; c <= STOP; c++) {
					for (d = -STOP; d <= STOP; d++) {
						if (a * c == A && b * c + d * a == B && b * d == C) {
							found = true;
							break;
						}
					}
					if (found) break;
				}
				if (found) break;
			}
			if (found) break;
		}
		String front = negative + ((gcf == 1) ? "" : Integer.toString(gcf)), ans = "";
		ans += "(" + ((a == 1) ? "" : a ) + "x" + ((b < 0) ? "-" : "+") + Math.abs(b) + ")";
		if (-b * 1.0 / a < -d * 1.0 / c) ans += "(" + ((c == 1) ? "" : c ) + "x" + ((d < 0) ? "-" : "+") + Math.abs(d) + ")";
		else ans = "(" + ((c == 1) ? "" : c ) + "x" + ((d < 0) ? "-" : "+") + Math.abs(d) + ")" + ans;
		System.out.println(front + ans);
	}
	public static int gcd (int A, int B) {
		return (B == 0) ? A : gcd(B, A % B);
	}
}
