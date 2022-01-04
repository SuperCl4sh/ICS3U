import java.io.*;
import java.util.*;

public class ics3u408 {
	public static double getMax (double A, double B, double C) {
		return Math.max(A, Math.max(B, C));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(getMax(sc.nextDouble(), sc.nextDouble(), sc.nextDouble()));
	}
}
