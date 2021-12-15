import java.io.*;
import java.util.*;

public class ics3u514 {
	public static final Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		int N = sc.nextInt();
		int ar[][][] = read_arr(N);
		System.out.println(get_size(ar));
	}
	public static int [][][] read_arr(int N) {
		int ret[][][] = new int [N][][];
		for (int i = 0; i < N; i++) {
			int tmp[][] = new int [100][];
			int cnt = 0;
			while (true) {
				int O = sc.nextInt();
				if (O == -1) break;
				tmp[cnt] = new int [O]; for (int j = 0; j < O; j++) tmp[cnt][j] = sc.nextInt();
				cnt++;
			}	
			ret[i] = new int [cnt][];
			for (int j = 0; j < cnt; j++) {
				int P = tmp[j].length;
				ret[i][j] = new int [P]; for (int k = 0; k < P; k++) ret[i][j][k] = tmp[j][k];
			}
		}
		return ret;
	}
	public static int get_size(int ar[][][]) {
		int ret = 0; for (int i = 0; i < ar.length; i++) for (int j = 0; j < ar[i].length; j++) ret += ar[i][j].length;
		return ret;
	}
}
