import java.io.*;
import java.util.*;

public class Main {
    // Initialize constants
    public static final Scanner sc = new Scanner(System.in);
    public static final double EPS = 1e-6; // Create epsilon constant for Double comparisons
    public static void main(String[] args) {
        System.out.println("Welcome to my triangle calculator. To use it, simply enter three positive numbers as the side lengths space separated on a single line. To terminate, enter 0 as the three side lengths (i.e '0 0 0' without the quotes)."); // Provide user with instructions on how to use calculator
        while (true) {
            double[] sides = validate(); // Validate sides
            if (sides.length == 0) break; // sides.length == 0 if and only if the user has entered three zeros as side lengths, in which case we terminate
            printSides(sides); // Print sides
            printTriangleType(sides); // Print the type of triangle (acute, right, obtuse and scalene, isosceles, right)
            printArea(sides); // Print the area of the formed triangle
            printAngles(angles(sides), sides); // Print the angles of the formed triangle
            System.out.println("-----------------------------"); // Print separator to separate different sessions
        }
        System.out.println("Thank you for playing. I hope you come again."); // Thank user for using the program and terminate
        return;
    }
    // A function to assert whether or not a condition is true
    public static void _assert(boolean condition) {
        if (!condition) throw new RuntimeException(); // If the condition is false, throw an error 
        return;
    }

    // A function to round a Double to two decimal places
    public static double roundTwoDecimal(double A) {
        return Math.round(100.0 * A) / 100.0;
    }

    // Functions to compare two Double values while considering epsilon
    public static final boolean doubleLessThan(double A, double B) {
        return B - A > EPS;
    }

    public static final boolean doubleGreaterThan(double A, double B) {
        return A - B > EPS;
    }

    public static final boolean doubleEqual(double A, double B) {
        return Math.abs(A - B) < EPS;
    }
    
    // A function to validate the user's input
    public static double[] validate() {
        double A, B, C;
        while (true) {
            System.out.print("Enter three side lengths: "); // Prompt the user to enter 3 side lengths 
            String[] line = sc.nextLine().split(" "); // Use in-built function to get the three values
            try {
                // Convert Strings to Doubles (throws an error if it cannot be converted) 
                A = Double.parseDouble(line[0]);
                B = Double.parseDouble(line[1]);
                C = Double.parseDouble(line[2]);
                // Check if the user wants to quit the program
                if (A == B && B == C && A == 0) {
                    // Create an array of length 0 and return it to indicate to the Main function that the user does not want to continue
                    double[] flag = new double[0];
                    return flag;
                }
                // Ensure that all entered values are valid (if any of the conditions is not true, an error is thrown)
                _assert(A > 0 && B > 0 && C > 0 && doubleGreaterThan(A + B + C - Math.max(A, Math.max(B, C)), Math.max(A, Math.max(B, C))));
                break;
            } catch (Exception e) { // Redirect errors here and inform users that their entered values are valid (done using try catch to improve clarity and conciseness)
                System.out.println("Invalid values. Please enter three valid, space separated, positive lengths on one line.");
                continue; // Restart loop (ask user for values again) since values were invalid
            }
        }
        double[] ret = {A, B, C}; // Move the user's sides into an array to faciliate value accesses
        return ret;
    }

    // A function to print the side lengths of the triangle
    public static void printSides(double[] sides) {
        System.out.println("The side lengths of the triangle entered are " + sides[0] + ", " + sides[1] + ", and " + sides[2] + ".");
        return;
    }

    // A function to print the triangle type
    public static void printTriangleType(double[] sides) {
        Arrays.sort(sides); // Sort array containing sides to simplify code
        double A = sides[0];
        double B = sides[1];
        double C = sides[2];
        // Inform user which type of triangle they have entered
        System.out.print("Your triangle is ");
        if (doubleEqual(A, B) && doubleEqual(B, C)) System.out.print("equilateral, ");
        else if (doubleEqual(A, B) || doubleEqual(B, C) || doubleEqual(A, C)) System.out.print("isosceles, ");
        else System.out.print("scalene, ");
        // Inform user the other type of triangle (uses cosine law)
        if (doubleEqual(C * C, A * A + B * B)) System.out.println("right.");
        else if (doubleLessThan(C * C, A * A + B * B)) System.out.println("acute.");
        else System.out.println("obtuse.");
        return;
    }

    // A function to calculate and print the perimeter of the triangle
    public static double perimeter(double[] sides) {
        double perim = roundTwoDecimal(sides[0] + sides[1] + sides[2]);
        System.out.println("The perimeter is " + perim + ".");
        return perim;
    }

    // A function to print the area of the triangle
    public static void printArea(double[] sides) {
        double s = (perimeter(sides)) / 2.0; // Calls the perimeter function, so we don't need to call separately to print values
        double A = sides[0];
        double B = sides[1];
        double C = sides[2];
        double area = roundTwoDecimal(Math.sqrt(s * (s - A) * (s - B) * (s - C))); // Use Heron's formula to calculate area (can also be used to determine whether or not three sides form a triangle)
        System.out.println("The area is " + area + ".");
        return;
    }

    // A function to calculate the angles of the triangle
    public static double[] angles(double[] sides) {
        double A = sides[0];
        double B = sides[1];
        double C = sides[2];
        double ret[] = new double[3];
        // Calculate angles using cosine law and round to two decimal places
        ret[0] = roundTwoDecimal(Math.toDegrees(Math.acos((A * A - B * B - C * C) / (-2.0 * B * C))));
        ret[1] = roundTwoDecimal(Math.toDegrees(Math.acos((B * B - A * A - C * C) / (-2.0 * A * C))));
        ret[2] = roundTwoDecimal(Math.toDegrees(Math.acos((C * C - A * A - B * B) / (-2.0 * A * B))));
        return ret;
    }

    // A function to print the angles of the triangle with their corresponding, opposite side
    public static void printAngles(double[] angles, double[] sides) {
        for (int i = 0; i < 3; i++) System.out.println("The angle opposite to " + sides[i] + " measures " + angles[i] + " degrees or " + roundTwoDecimal(Math.toRadians(angles[i])) + " radians."); // Provide user with both degrees and radian measures, rounded to two decimal places
        return;
    }
}
