import java.io.*;
import java.util.*;

public class  ics3u308 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final String PASS = "coded";
		String line = "";
		do {
			System.out.println("Enter Password:");
			line = sc.nextLine();
		} while (!line.equals(PASS));
		System.out.println("Access Granted!");
	}
}
