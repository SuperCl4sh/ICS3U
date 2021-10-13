import java.io.*;
import java.util.*;
public class  ics3u1095circle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final double pi = 3.14;
		System.out.println("Enter the radius:");
		double radius = sc.nextDouble();
		double area = (10 * pi * radius * radius) / 10;
		double circum = (10 * pi * radius * 2) / 10;
		System.out.println("A = " + area + " units ^2");
		System.out.println("C = " + circum + " units");
	}
}
