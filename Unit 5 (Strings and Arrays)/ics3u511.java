import java.io.*;
import java.util.*;

public class ics3u511 {
	public static final Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		int R = sc.nextInt(), C = sc.nextInt();
		int ar[][] = new int [R][];
		for (int i = 0; i < R; i++) {
			ar[i] = new int [C];
			for (int j = 0; j < C; j++) ar[i][j] = sc.nextInt();
		}
		for (int i = C - 1; i >= 0; i--) {
			for (int j = R - 1; j >= 0; j--) System.out.print(ar[j][i]);
			System.out.println();
		}
	}
}
