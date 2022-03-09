package Wordle;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Wordle.GUI;

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