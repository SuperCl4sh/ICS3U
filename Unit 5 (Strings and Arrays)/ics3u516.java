import java.io.*;
import java.util.*;

public class ics3u516 {
	public static final Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		int N = sc.nextInt();
		String partners[][] = new String[N][2];
		String skip = sc.nextLine();
		for (int i = 0; i < 2; i++) {
			String line[] = sc.nextLine().split(" ");
			for (int j = 0; j < N; j++) partners[j][i] = line[j];
		}
		for (int i = 0; i < N; i++) Arrays.sort(partners[i]);
		boolean valid = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				valid &= !(partners[i][0].equals(partners[i][1]) || partners[j][0].equals(partners[j][1]));
				if (i == j || Arrays.equals(partners[i], partners[j])) continue;
				for (int l = 0; l < 2; l++) {
					for (int m = 0; m < 2; m++) {
						if (partners[i][l].equals(partners[j][m])) valid = false;
					}
				}
			}
		}
		System.out.println((valid) ? "good" : "bad");	
	}
}
