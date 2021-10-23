import java.io.*;
import java.util.*;

public class ics3u114 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Temp in F:");
		double F = sc.nextDouble();
		System.out.println("Temp in C:");
		double C = Math.round(5.0/9 * (F - 32) * 10.0) / 10.0;
		System.out.println(C);	
	}
}
