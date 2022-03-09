package Wordle;
import java.io.*;
import java.util.*;

public class Wordle {
	private final static int MAX_NUMBER_WORDS = 2315;
	public static void main(String[] args) throws IOException {
		String[] words = new String[MAX_NUMBER_WORDS];
		Scanner sc = new Scanner(new File("Wordle/wordleWords.txt"));
		int i = 0;
		while (sc.hasNextLine()) words[i++] = sc.next().toUpperCase();
		new GUI(words);
		return;
	}
}