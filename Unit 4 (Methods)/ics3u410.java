import java.io.*;
import java.util.*;

public class ics3u410 {
	public static int gcd (int A, int B) {
		return B == 0 ? A : gcd(B, A % B);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(gcd(sc.nextInt(), sc.nextInt()));
	}
}
