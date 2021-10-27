import java.io.*;
import java.util.*;

public class ics3ucompassu2ass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (0 <= N && N <= 45) System.out.println("N");
		else if (N < 135) System.out.println("E");
		else if (N <= 225) System.out.println("S");
		else if (N < 360) System.out.println("W");
		else System.out.println("Invalid");
	}
}
