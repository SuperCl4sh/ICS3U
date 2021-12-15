import java.io.*;
import java.util.*;

public class ics3u513 {
	public static final Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		int R = sc.nextInt();
		int grid[][] = new int [R][];
		for (int i = 0; i < R; i++) {
			int C = sc.nextInt();
			grid[i] = new int [C]; for (int j = 0; j < C; j++) grid[i][j] = sc.nextInt();
		}
		System.out.println(get_max(grid));
	}
	public static int get_max(int[][] grid) {
		int ret = -(1 << 30); for (int i = 0; i < grid.length; i++) for (int j = 0; j < grid[i].length; j++) ret = Math.max(ret, grid[i][j]);
		return ret;
	}
}
