import java.io.*;
import java.util.*;

public class ics3ucompassu2ass1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String firstDir[] = new String [370];
		String secondDir[] = new String [370];
		int bearings[] = new int [370];
		String compasses[] = new String [370];
		for (int i = 0; i <= 45; i++) {
			firstDir[i] = "N";
			secondDir[i] = "E";
			bearings[i] = i;
		}
		for (int i = 46; i < 135; i++) {
			firstDir[i] = "E";
			secondDir[i] = (i <= 90) ? "N" : "S";
			bearings[i] = Math.abs(90 - i) % 45;
		}
		for (int i = 135; i <= 225; i++) {
			firstDir[i] = "S";
			secondDir[i] = (i <= 180) ? "E" : "W";
			bearings[i] = Math.abs(180 - i);
		}
		for (int i = 226; i < 315; i++) {
			firstDir[i] = "W";
			secondDir[i] = (i <= 270) ? "S" : "N";
			bearings[i] = Math.abs(270 - i);
		}
		for (int i = 315; i < 360; i++) {
			firstDir[i] = "N";
			secondDir[i] = "W";
			bearings[i] = (360 - i);
		}
		for (int i = 0; i < 360; i++) {
			compasses[i] = "" + firstDir[i] + ((bearings[i] == 0) ? "" : bearings[i]) + secondDir[i];
			if (i % 90 == 0) {
				compasses[i] = "" + compasses[i].charAt(0);
				continue;
			}
		}
		String first = sc.nextLine();
		int bearing = sc.nextInt(); 
		String skip = sc.nextLine();
		String second = sc.nextLine();
		String compass = "" + first + "" + bearing + "" + second;
		int i;
		for (i = 0; i < 360; i++) {
			if (compasses[i].equals(compass)) break;
		}
		System.out.println((i == 360) ? "Invalid" : "Compass " + compass + " is a bearing of " + i);
	}
}
