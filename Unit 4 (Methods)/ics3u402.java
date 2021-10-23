import java.io.*;
import java.util.*;

public class ics3u402 {
	public static void dieRoll() {
		System.out.println("You rolled a " + (int)(Math.random() * 5 + 1));
	}
	public static void main(String[] args) {
		dieRoll();
	}
}
