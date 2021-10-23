import java.io.*;
import java.util.*;

public class  ics3u309 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter integer 1:\n");
		int firstNum = sc.nextInt();
		System.out.print("Enter integer 2:\n");
		int secNum = sc.nextInt();
		System.out.print("Print asterisks:\n");
		String tmp = "";
		for (int i = 0; i < Math.abs(firstNum - secNum); i++) tmp += '*';
		System.out.print(tmp + '\n');
		System.out.print("Countdown seconds:\n");
		for (int i = Math.max(firstNum, secNum); i >= Math.min(firstNum, secNum); i--) System.out.print(i + " seconds\n");
		System.out.print("Enter a letter:\n");
		char firstChar = sc.next().charAt(0);
		System.out.print("Enter a letter:\n");
		char secChar = sc.next().charAt(0);
		for (char start = firstChar; start <= secChar; start++) System.out.print("Give me a " + start + "" + '\n');
		System.out.print("Output multiples - start at integer 1 and multiply by integer 2 stop when greater than 1000\n");
		for (int start = firstNum; start <= 1000; start *= secNum) System.out.print(start + "" + '\n');
	}
}
