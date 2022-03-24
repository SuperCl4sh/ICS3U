import java.io.*;
import java.util.*;

/*
Q1: 
a) 4/5
b) -9/-7
c) 5/6
d) -9/-12
e) 13/20
*/

class Fraction {
    int num, den;
    public int gcd(int A, int B) {
        return B == 0 ? A : gcd(B, A % B);
    }
    public void plusEquals(Fraction A) {
        this.num = this.num * A.den + this.den * A.num;
        this.den *= A.den;
        return;
    }
    public Fraction plus(Fraction A) {
        Fraction ret = new Fraction();
        ret.num = this.num * A.den + this.den * A.num;
        ret.den = this.den * A.den;
        return ret;
    }
    public void reduce() {
        int gcd = gcd(this.num, this.den);
        this.num /= gcd;
        this.den /= gcd;
        return;
    }
    public void print() {
        System.out.println(this.num + "/" + this.den);
        return;
    }
}

public class ics3u602 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) { 
        Scanner s = new Scanner(System.in);
        Fraction a = new Fraction();
        Fraction b = new Fraction();
        Fraction c = new Fraction();
        Fraction d = new Fraction();

        //set fractions with user input
        a.num = s.nextInt();
        a.den = s.nextInt();
        b.num = s.nextInt();
        b.den = s.nextInt();
        c.num = s.nextInt();
        c.den = s.nextInt();

        //call instance methods
        a.plusEquals(b);
        d = a.plus(c);
        d.reduce();

        //print fractions with instance method
        a.print();
        b.print();
        c.print();
        d.print();
        return;
    }
}
