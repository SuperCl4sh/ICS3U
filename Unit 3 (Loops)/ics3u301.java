import java.io.*;
import java.util.*;

public class  ics3u301 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentinel value:");
		int sent = sc.nextInt(), guess = -(1 << 25);
		while (guess != sent) {
			System.out.println("Enter an integer:");
			guess = sc.nextInt();
		}
		System.out.println("Stop");
	}
}
