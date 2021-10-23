import java.io.*;
import java.util.*;

public class  ics3u304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int val, prev = sc.nextInt(), ans = 0;
		while (prev != 0) {
			val = sc.nextInt();
			if (val == prev) ans++;
			prev = val;
		}
		System.out.println("There are " + ans + " cases of consecutive values");
	}
}


