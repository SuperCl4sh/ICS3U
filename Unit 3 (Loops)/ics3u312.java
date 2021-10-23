import java.io.*;
import java.util.*;

public class  ics3u312 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) System.out.println(N + " x " + i + " = " + (i * N));
	}
}
