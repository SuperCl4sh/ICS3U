import java.io.*;
import java.util.*;

public class ics3u202 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = (int)(Math.pow(10, 9));
		
		System.out.println("Enter first number:");
		int tmp = sc.nextInt();
		if (tmp < ans) ans = tmp;
		
		System.out.println("Enter second number:");
		tmp = sc.nextInt();
		if (tmp < ans) ans = tmp;
		
		System.out.println("Enter third number:");
		tmp = sc.nextInt();
		if (tmp < ans) ans = tmp;
		
		System.out.println("The smallest number is: " + ans);
	}
}
