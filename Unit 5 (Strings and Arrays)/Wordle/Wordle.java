// Seyon Sivatharan
// 3/11/2022

package Wordle;
import java.io.*;
import java.util.*;

public class Wordle {
	private final static int MAX_NUMBER_WORDS_WORDLE = 2315;
	private final static int MAX_NUMBER_WORDS_ENGLISH = 27285;
	public static void main(String[] args) throws IOException {
		// Read Wordle file and store in array
		String[] wordle = new String[MAX_NUMBER_WORDS_WORDLE];
		Scanner sc = new Scanner(new File("Wordle/wordleWords.txt"));
		int i = 0;
		while (sc.hasNextLine()) wordle[i++] = sc.next().toUpperCase();
		// Read file of valid engilsh words and store in array, removing invalid words
		String[] english = new String[MAX_NUMBER_WORDS_ENGLISH];
		i = 0;
		Scanner sc1 = new Scanner(new File("Wordle/englishWords.txt"));
		while (sc1.hasNextLine()) {
			String word = sc1.nextLine();
			if (word.length() == 5 && !word.matches("^.*[^a-zA-Z0-9 ].*$")) english[i++] = word.toUpperCase();
		}
		new GUI(wordle, english); // Create GUI
		return;
	}
}