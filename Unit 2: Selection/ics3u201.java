import java.io.*;
import java.util.*;

public class ics3u201 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Simple Math Quiz\n");
		String questions[] = new String[3];
		int answers[] = new int[3];
		questions[0] = "5+2 = ";
		answers[0] = 7;
		questions[1] = "3*6 = ";
		answers[1] = 18;
		questions[2] = "88-3 = ";
		answers[2] = 85;
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			System.out.println("Question " + (i + 1) + ":\n" + questions[i]);
			int userAns = sc.nextInt();
			if (userAns == answers[i]) ++cnt;
			System.out.println(((userAns == answers[i]) ? "Correct." : "Incorrect. " + questions[i] + answers[i]) + "\n");
		}
		System.out.println("Score: " + cnt + "/3");

	}
}
