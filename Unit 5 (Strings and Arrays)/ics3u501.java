import java.io.*;
import java.util.*;

public class ics3u501 {
	public static void main(String[] args) {
		//Q1
		//4
		//0
		//3
		Scanner sc = new Scanner(System.in);
		int ar[] = new int[10]; for (int i = 0; i < 10; i++) ar[i] = sc.nextInt();
		int tmp = ar[0];
		ar[0] = ar[9];
		ar[9] = tmp;
		for (int i = 0; i < 10; i++) ar[i] = Math.abs(ar[i]);
		int sampleSum = 0; for (int i = 0; i < 10; i++) sampleSum += ar[i];
		System.out.println(sampleSum);
		for (int i = 0; i < 10; i += 2) System.out.print(ar[i] + " ");
		System.out.println();
	}
}
