import java.io.*;
import java.util.*;

public class ics3u407 {
	public static int randomNumber() {
		return (int)(Math.random() * 5 + 1);
	}
	public static int randomNumber(int N) {
		return (int)(Math.random() * N + 1);
	}
	public static int randomNumber(int low, int high) {
		return (int)(Math.random() * (high - low) + low);
	}
	public static int randomNumber(int low, int high, int step) {
		int ret = (int)(Math.random() * (high - low) + low);
		while ((ret - low) % step > 0) ret = (int)(Math.random() * (high - low) + low);
		return ret;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), low = sc.nextInt(), high = sc.nextInt(), step = sc.nextInt();
		System.out.println(randomNumber());
		System.out.println(randomNumber(N));
		System.out.println(randomNumber(low, high));
		System.out.println(randomNumber(low, high, step));
	}
}
