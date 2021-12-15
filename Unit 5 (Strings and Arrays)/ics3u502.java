import java.io.*;
import java.util.*;

public class ics3u502 {
	public static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		int N = sc.nextInt();
		double[] ar = getArray(N);
		System.out.println(max(ar));
	}
	public static double[] getArray(int N) {
		double[] ret = new double[N]; for (int i = 0; i < N; i++) ret[i] = sc.nextDouble();
		return ret;
	}
	public static double max(double[] ar) {
		double ret = 0; for (int i = 0; i < ar.length; i++) ret = (ar[i] > ret) ? ar[i] : ret;
		return ret;
	}
}
