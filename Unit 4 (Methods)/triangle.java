import java.io.*;
import java.util.*;

public class triangle {
	public static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while (true) {
			System.out.print("Enter three side lengths: ");
			double[] sides = validate();
			if (sides.length == 0) break;
			System.out.println("The side lengths of the triangle entered are " + sides[0] + ", " + sides[1] + ", and " + sides[2] + ".");
			System.out.println("The area is " + area(sides) + ".");	
			System.out.println("The perimeter is " + perimeter(sides) + ".");
			int[] angles = angles(sides);
			System.out.println("Its angles are " + angles[0] + ", " + angles[1] + ", and " + angles[2]);
		}
		System.out.println("Thank you for playing. I hope you come again.");
    	}
	public static void _assert(boolean condition) {
		if (!condition) throw new RuntimeException();
	}
	public static int[] angles(double[] sides) {
		double A = sides[0];
		double B = sides[1];
		double C = sides[2];
		int ret[] = new int [3];
		ret[0] = (int)Math.round(Math.toDegrees(Math.acos((C * C - A * A - B * B) / (- 2.0 * A * B))));
		ret[1] = (int)Math.round(Math.toDegrees(Math.acos((A * A - B * B - C * C) / (-2.0 * B * C))));
		ret[2] = (int)Math.round(Math.toDegrees(Math.acos((B * B - A * A - C * C) / (-2.0 * A * C))));
		return ret;
	}
	public static double perimeter(double[] sides) {
		return sides[0] + sides[1] + sides[2];
	}
	public static double area(double[] sides) {
		double s = (perimeter(sides)) / 2.0;
		double A = sides[0];
		double B = sides[1];
		double C = sides[2];
		return Math.sqrt(s * (s - A) * (s - B) * (s - C));
	}
	public static double[] validate() {
		double A, B, C;
		while (true) {
			String[] line = sc.nextLine().split(" ");
			try {
				_assert(line.length == 3);
				A = Double.parseDouble(line[0]);
				B = Double.parseDouble(line[1]);
				C = Double.parseDouble(line[2]);
				if (A == B && B == C && A == 0) {
					double[] flag = new double [0]; return flag;
				}
				_assert(A > 0 && B > 0 && C > 0 && A + B + C - Math.max(A, Math.max(B, C)) > Math.max(A, Math.max(B, C)));
				break;
			}
			catch (Exception e) {
				System.out.println("Invalid values or number and/or values. Please enter three positive integer lengths.");
				continue;
			}
		}
		double[] ret = new double [3];
		ret[0] = A; ret[1] = B; ret[2] = C;
		return ret;
	}
}
