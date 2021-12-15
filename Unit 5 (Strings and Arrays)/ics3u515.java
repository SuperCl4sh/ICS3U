import java.io.*;
import java.util.*;

public class ics3u515 {
	public static final Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		int V = sc.nextInt();
		String S = sc.next();
		long A = S.chars().filter(ch -> ch == 'A').count(), B =S.chars().filter(ch -> ch == 'B').count();
		System.out.println(((A > B) ? "A" : ((A == B) ? "Tie" : "B")));  
	}
}
