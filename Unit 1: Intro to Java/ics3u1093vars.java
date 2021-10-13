import java.io.*;
import java.util.*;
public class  ics3u1093vars {
	public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
		System.out.println("Enter four course grades:");
		double tot = 0.0;
		for (int i = 0; i < 4; i++) tot += sc.nextDouble();
		System.out.println("The average is: " + tot / 4);
	}
}
