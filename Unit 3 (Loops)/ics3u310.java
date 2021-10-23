import java.io.*;
import java.util.*;

public class  ics3u310 {
	public static int fun(int X) {
		return 2 * X + 5;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Part a");
		for (int i = 6; i >= 0; i--) System.out.println(i + " --> " + fun(i));
		System.out.println();
		System.out.println("Part b");
		for (int i = 0; i <= 30; i += 3) System.out.println(i + " --> " + fun(i));
		System.out.println();
		System.out.println("Part c");
		for (int i = -15; i <= 15; i += 5) System.out.println(i + " --> " + fun(i));
		System.out.println();
		System.out.println("Part d");
		for (int i = 1; i <= 1024; i *= 2) System.out.println(i + " --> " + fun(i));
	}
}
