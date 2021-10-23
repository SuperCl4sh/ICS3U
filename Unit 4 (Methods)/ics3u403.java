import java.io.*;
import java.util.*;

public class ics3u403 {
	public static int getRoll() {
		return (int)(Math.random() * 5 + 1);
	}
	public static void twoDieRoll() {
		int firstRoll = getRoll(), secRoll = getRoll();
		System.out.println(firstRoll + " and " + secRoll + " ==> total " + (firstRoll + secRoll));
	}
	public static void main(String[] args) {
		twoDieRoll();
	}
}
