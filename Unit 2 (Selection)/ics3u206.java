import java.io.*;
import java.util.*;

public class ics3u206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 3 integer values:");
		int nums[] = new int [3]; for (int i = 0; i < 3; i++) nums[i] = sc.nextInt();
		for (int i = 0; i < 3; i++) {
			for (int j = i + 1; j < 3; j++) {
				if (nums[i] > nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		for (int i = 0; i < 3; i++) System.out.print(nums[i] + ((i != 2) ? ", " : "\n"));
	}
}
