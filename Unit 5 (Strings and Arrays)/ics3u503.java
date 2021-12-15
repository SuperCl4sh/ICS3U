import java.io.*;
import java.util.*;

public class ics3u503 {
	public static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		int N = sc.nextInt();
		double[] ar = getArray(N);
		int N2 = sc.nextInt();
		double[] ar2 = getArray(N2);
		System.out.println(equals(ar, ar2));
	}
	public static double[] getArray(int N) {
		double[] ret = new double[N]; for (int i = 0; i < N; i++) ret[i] = sc.nextDouble();
		return ret;
	}
	public static boolean equals(double[] ar, double[] ar2) {
		if (ar.length != ar2.length) return false;
		boolean ret = true; for (int i = 0; i < ar.length && ret; i++) ret = (ar[i] == ar2[i]);
		return ret;
	}
}
