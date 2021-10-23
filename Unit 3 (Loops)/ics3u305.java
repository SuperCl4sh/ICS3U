import java.io.*;
import java.util.*;

public class  ics3u305 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Continue (y or n):");
			String line = sc.nextLine();
			if (line.length() == 1 && (line.charAt(0) == 'y' || line.charAt(0) == 'n')) break;
		}
		System.out.println("done");
	}
}


