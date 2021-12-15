import java.io.*;
import java.util.*;

public class ics3u517 {
	public static final Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		int K = sc.nextInt(), M = sc.nextInt();
		int people[] = new int [K + 1]; for (int i = 1; i <= K; i++) people[i] = i;
		for (int __ = 0; __ < M; __++) {
			int R = sc.nextInt(), cnt = 0;
			for (int i = 1; i <= K; i++) {
				if (people[i] == -1) continue;
				cnt++;
				if (cnt == R) people[i] = -1;
				cnt %= R;
			}
		}
		for (int i = 1; i <= K; i++) if (people[i] != -1) System.out.println(people[i]);
	}
}
