import java.io.*;
import java.util.*;

public class ics3ucompassu2assa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N < 0 || N >= 360) System.out.println("Invalid");
		else {
			System.out.print("Bearing " + N + " is closest to ");
			if (0 <= N && N <= 45) System.out.println("North");
			else if (N < 135) System.out.println("East");
			else if (N <= 225) System.out.println("South");
			else if (N < 360) System.out.println("West");
		}
	}
}
