import java.io.*;
import java.util.*;

public class triangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Enter three side lengths: ");
			String[] line = sc.nextLine().split(" ");
			System.out.println(line.length);
			if (line.length != 3) {
				System.out.println("Invalid number of values. Please enter three values.");
				continue;
			}
			int A, B, C;
			try {
				A = Integer.parseInt(line[0]);
				B = Integer.parseInt(line[1]);
				C = Integer.parseInt(line[2]);
			}
			catch (Exception e) {
				System.out.println("Invalid values. Please enter positive integer lengths.");
				continue;
			}
			if ((A | B | C) == 0) break;
			System.out.println("The side lengths of the triangle entered are " + A + ", " + B + ", and " + C);
			if ((A | B | C) < 0 || A <= 0 || B <= 0 || C <= 0 || A + B + C - Math.max(A, Math.max(B, C)) <= Math.max(A, Math.max(B, C))) {
				System.out.println("Entered side lengths are invalid. Please enter positive integer side lengths.");
				continue;
			}
		}
		System.out.println("Thank you for playing. I hope you come again.");
    	}
}
