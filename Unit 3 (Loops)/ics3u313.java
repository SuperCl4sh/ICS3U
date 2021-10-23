import java.io.*;
import java.util.*;

public class  ics3u313 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine().replace(" ", "").toLowerCase();
		boolean good = true;
		for (int i = 0, j = S.length() - 1; i < j; i++, j--) good &= (S.charAt(i) == S.charAt(j));
		System.out.println(good);
	}
}
