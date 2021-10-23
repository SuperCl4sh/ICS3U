import java.io.*;
import java.util.*;

public class ics3u207 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter quadratic equation a, b and c");
		double A = sc.nextDouble();
		double B = sc.nextDouble();
		double C = sc.nextDouble();
		double discr = B * B - 4 * A * C;
		double firstSol = Math.round(10 * (-B + Math.sqrt(discr)) / (2 * A)) / 10.0;
		double secondSol = Math.round(10 * (-B - Math.sqrt(discr)) / (2 * A)) / 10.0;
		if (discr < 0) System.out.println("This has no solution");
		else if (discr == 0.0) {
			System.out.println("This has one solution x=" + firstSol);
		}
		else {
			System.out.println("This has two solutions x=" + Math.min(firstSol, secondSol) + " and x=" + Math.max(firstSol, secondSol));
		}
	}
}
