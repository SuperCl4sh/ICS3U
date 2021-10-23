import java.io.*;
import java.util.*;

public class  ics3u311 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		double tot = 0;
		for (int i = 1; i <= 1000; i++) tot += 1.0 / i;
		System.out.println(tot);
		tot = 0;
		for (int i = 100; i <= 5000; i += 100) tot += Math.sqrt(i);
		System.out.println(tot);
		tot = 1;
		for (int i = 1; i <= 20; i++) tot *= i;
		System.out.println((long)tot);
		tot = 0;
		for (int i = 13; i <= 20; i++) tot += Math.pow(i, 3);
		System.out.println((long)tot);
		tot = 0;
		for (int i = 1; i <= 25; i++) tot += Math.pow(i, 1.0 / i);
		System.out.println(tot);
	}
}
