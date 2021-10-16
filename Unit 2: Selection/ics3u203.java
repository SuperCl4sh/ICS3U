import java.io.*;
import java.util.*;

public class ics3u203 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		
		System.out.println("Enter first number:");
		int tmp = sc.nextInt();
		if (tmp > ans) ans = tmp;
		
		System.out.println("Enter second number:");
		tmp = sc.nextInt();
		if (tmp > ans) ans = tmp;
		
		System.out.println("Enter third number:");
		tmp = sc.nextInt();
		if (tmp > ans) ans = tmp;
		
		System.out.println("The largest number is: " + ans);
	}
}


