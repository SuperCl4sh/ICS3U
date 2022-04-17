import java.io.*;
import java.util.*;

class Student {
    String name, password;
    int grade, age;
    public Student() {
        this.name = "student";
        this.grade = 9;
        this.age = 14;
        this.password = "cb";
    }
    public Student(String name, int grade, int age) {
        this.name = name;
        this.grade = grade;
        this.age = age;
        this.password = "cb";
    }
    public Student(String name) {
        this.name = name;
        this.grade = 9;
        this.age = 14;
        this.password = "cb";
    }
    public void print(){

        // Prints a chart displaying the student's info

        System.out.println("-------------------------------------------------");
        System.out.println("STUDENT INFO |             ");
        System.out.println("Name         | " + this.name);
        System.out.println("Age          | " + this.age);
        System.out.println("Grade        | " + this.grade);
        System.out.println("Password     | " + this.password);

    }
}
    
public class Main {
    public static void main(String[] args) {

        // Instance of Student using default constructor
        Student s1 = new Student();

        // Instance of Student using constuctor 2
        Student s2 = new Student("William Gates", 11, 16);

        // Instance of Student using constructor 3
        Student s3 = new Student("Steven Jobs");

        s1.print();
        s2.print();
        s3.print();
    }
}
