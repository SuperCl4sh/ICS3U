import java.io.*;
import java.util.*;

public class ics3u512 {
	public static final Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		int R = sc.nextInt(), C = sc.nextInt();
		int grid[][] = new int [R][:;
		for (int i = 0; i < R; i++) {
			grid[i] = new int [C];
			for (int j = 0; j < C; j++) grid[i][j] = sc.nextInt();
		}
		System.out.println(getSum(grid, R, C));
	}
	public static int getSum(int grid[][], int R, int C) {
		int tot = 0; for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) tot += grid[i][j];
		return tot;
	}
}
