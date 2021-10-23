import java.io.*;
import java.util.*;

public class ics3u113 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("numerator=");
		int nume = sc.nextInt();
		System.out.println("denominator=");
		int deno = sc.nextInt();
		System.out.println(nume + " / " + deno + " is equivalent to " + (int)(nume / deno) + " and " + nume % deno + " / " + deno); 
	}
}
