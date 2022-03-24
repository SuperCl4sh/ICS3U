import java.io.*;
import java.util.*;

class Fraction {
    public int num, den;
    public Fraction multiply(Fraction A) {
        Fraction ret = new Fraction();
        ret.num = A.num * this.num;
        ret.den = A.den * this.den;
        return ret;
    }

    public Fraction add(Fraction A) {
        Fraction ret = new Fraction();
        ret.num = A.den * this.num + this.den * A.num;
        ret.den = A.den * this.den;
        return ret;
    }

    public void print() {
        System.out.println(this.num + "/" + this.den);
        return;
    }
}
/*
Q1:
Fraction frac = new Fraction();
frac.num = 2;
frac.den = 7;
*/

/*
Q2: The error will be null pointer exception since there is no actual instance of the Fraction class at the variable.
*/

/*
Q3:
Since r = q, q and r will be the same value (4/3).
p is not bound to anything, so all the operations function as one would expect, which gives it a value of 1/3.
*/

public class ics3u600 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) { 
        Fraction f1 = new Fraction();
        f1.num = sc.nextInt();
        f1.den = sc.nextInt();
        Fraction f2 = new Fraction();
        f2.num = sc.nextInt();
        f2.den = sc.nextInt();

        f1.num *= 2;
        f1.print();

        f2.num ^= f2.den;
        f2.den ^= f2.num;
        f2.num ^= f2.den;
        f2.print();

        f1 = f1.multiply(f2);
        f1.print();

        f2 = f2.add(f1);
        f2.print();

        f1.num = Math.max(f1.num, -f1.num);
        f1.den = Math.max(f1.den, -f1.den);
        f1.print();
        return;
    }
}
