// Probabalistic solution
import java.io.*;
import java.util.*;

public class ics3u209challengev2 {
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
		int a = -1, b = -1, c = -1, d = -1;
		final int LOW = -30;
		final int HIGH = 30;
		final int ITER = (int)Math.pow(10, 7);
		int cnt = 0;
		for (int i = 0; i < ITER; i++) {
			a = (int)(Math.random() * (HIGH - 1) + 1);
			b = (int)(Math.random() * (HIGH - LOW + 1) + LOW);
			c = (int)(Math.random() * (HIGH - 1) + 1);
			d = (int)(Math.random() * (HIGH - LOW + 1) + LOW);
			if (a * c == A && b * d == C && b * c + a * d == B) break;
		}
		if (a == -1) {
			System.out.println("ERROR");
			return;
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
