import java.io.*;
import java.util.*;

class Student {
    public String fname, lname;
    public int age, grade;
}

public class ics3u601 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) { 
        Student[] students = new Student[4];
        for (int i = 0; i < 4; i++) {
            students[i] = new Student();
            students[i].fname = sc.nextLine();
            students[i].lname = sc.nextLine();
            students[i].age = Integer.parseInt(sc.nextLine());
            students[i].grade = Integer.parseInt(sc.nextLine());
        }
        System.out.println(students[0].fname);
        System.out.println(students[1].lname);
        System.out.println(students[2].age);
        System.out.println(students[3].grade);
        return;
    }
}
