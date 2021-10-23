import java.io.*;
import java.util.*;

public class ics3u404 {
	public static int rollDie() {
		return (int)(Math.random() * 5 + 1);
	}
	public static void printRollDice(int N) {
		for (int i = 1; i <= N; i++) System.out.println("Roll " + i + " is a " + rollDie());
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		printRollDice(sc.nextInt());
	}
}
