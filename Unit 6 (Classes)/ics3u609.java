import java.io.*;
import java.util.*;

class Fraction {
    private int num, den;
    public Fraction(int num, int den) {
        this.num = num;
        this.den = den;
    }
    int getGCD(int A, int B) {
        if (A < 0) A *= -1;
        if (B < 0) B *= -1;
        return (B == 0) ? A : getGCD(B, A % B);
    }
    void reduce() {
        int gcd = getGCD(this.num, this.den);
        this.num /= gcd;
        this.den /= gcd;
    }
    public static Fraction product(Fraction A, Fraction B) {
        Fraction C = new Fraction(0, 0);
        C.num = A.num * B.num;
        C.den = A.den * B.den;
        C.reduce();
        return C;
    }
    public static Fraction abs(Fraction A) {
        Fraction B = new Fraction(A.num, A.den);
        if (B.num < 0) B.num *= -1;
        if (B.den < 0) B.den *= -1;
        B.reduce();
        return B;
    }
    public static boolean isPositive(Fraction A) {
        return A.num > 0 && A.den > 0;
    }
    public void print() {
        System.out.println("" + this.num + "/" + this.den);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Fraction p = new Fraction(s.nextInt(), s.nextInt());
        Fraction q = new Fraction(s.nextInt(), s.nextInt());
        Fraction.product(p, q).print(); // 1 
        Fraction.abs(q).print();        // 2

        System.out.println(Fraction.isPositive(p)); // 3
        System.out.println(Fraction.isPositive(q)); // 3
    }
}
