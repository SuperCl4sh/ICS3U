import java.io.*;
import java.util.*;
public class  ics3u1094vars {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double marks[] = new double [5]; //create one-indexed array to clean up code
		double tot = 0; //initialize total
		for (int i = 1; i < 5; i++) { //iterate 4 times
			System.out.println("Enter mark " + i + ":"); //print required information
			marks[i] = sc.nextDouble(); //read double
			tot += marks[i]; //increment total variable by the value of the inputted value
			System.out.print("Marks: ");
			for (int j = 1; j <= i; j++) { //print marks
				System.out.print(marks[j]);
				if (i != j) System.out.print(", "); //print comma and space
				else System.out.println(); //print new line
			}
			if (i > 1) System.out.println("Mark total is " + tot);
		}
		double average = tot / 4.0;
		System.out.println("The average is " + average);
	}
}
