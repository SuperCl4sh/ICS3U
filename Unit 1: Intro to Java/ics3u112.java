import java.io.*;
import java.util.*;

public class ics3u112 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number:");
		double num = sc.nextDouble();
		System.out.println("Number of decimal places:");
		int places = sc.nextInt();
		double rounded = Math.round(num * Math.pow(10, places)) / Math.pow(10, places);
		System.out.println(rounded);	
	}
}
