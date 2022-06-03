import java.io.*;
import java.util.*;

public class adpp {
    public static final Scanner sc = new Scanner(System.in);
    public static final int MAX_VAL = (int)Math.pow(10, 4);
    public static final long MOD =  998244353;
    public static void main(String[] args) {
        int N = sc.nextInt();
        long K = sc.nextLong();
        int Q = sc.nextInt();
        long[] freq = new long[MAX_VAL + 1];
        for (int i = 0; i <= MAX_VAL; i++) freq[i] = 0;
        for (int i = 0; i < N; i++) freq[sc.nextInt()]++;
        freq[0] = 1;
        long[] ans = new long[MAX_VAL + 1];
        freq[0] = 1;
        boolean gone = false;
        while (K > 0) {
            if (K % 2 > 0) {
                if (!gone) {
                    ans = Arrays.copyOfRange(freq, 0, MAX_VAL + 1);
                    gone = true;
                }
                else {
                    long[] res = karatsuba(ans, freq);
                    //printPolynomial(res);
                    //printPolynomial(multiply(ans, freq));
                    //_assert(Arrays.equals(res, multiply(ans, freq)));
                    ans = Arrays.copyOfRange(res, 0, MAX_VAL + 1); 
                }
            }
            long[] prodRes = karatsuba(freq, freq);
            //_assert(Arrays.equals(prodRes, multiply(freq, freq)));
            //printPolynomial(multiply(freq, freq));
            //System.out.println();
            //printPolynomial(prodRes);
            //System.out.println();
            freq = Arrays.copyOfRange(prodRes, 0, MAX_VAL + 1); 
            K >>= 1;
        }
        //for (int i = 0; i <= MAX_VAL; i++) System.out.print(ans[i] + " ");
        //System.out.println();
        long[] psa = new long[MAX_VAL + 1];
        psa[0] = ans[0];
        for (int i = 1; i <= MAX_VAL; i++) psa[i] = (psa[i - 1] + ans[i]) % MOD;
        for (int i = 0; i < Q; i++) {
            int L = sc.nextInt(), R = sc.nextInt();
            System.out.println((psa[R] - ((L == 0) ? 0 : psa[L - 1]) + MOD) % MOD);
        }
        return;
    }

    public static void _assert(boolean condition) {
        if (!condition) throw new RuntimeException("Assert failed!");
        return;
    }

    public static void printPolynomial(long[] A) {
        for (int i = 0; i < A.length; i++) System.out.print(A[i] + "x^" + i + " ");
        System.out.println();
        return;
    }

    public static long[] addZero(long[] A, int m) {
        long[] res = new long[A.length + m];
        for (int i = 0; i < m; i++) res[i] = 0;
        for (int i = m; i < A.length + m; i++) res[i] = A[i - m];
        return res;
    }

    public static long[] fix(long[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] += MOD;
            _assert(A[i] >= 0);
            A[i] %= MOD;
        }
        return A;
    }

    public static long[] multiply(long[] A, long[] B) {
        long res[] = new long[A.length + B.length - 1];
        //for (int i = 0; i < A.length; i++) System.out.print(A[i] + " ");
        //System.out.println();
        //for (int i = 0; i < B.length; i++) System.out.print(B[i] + " ");
        //System.out.println();
        for (int i = 0; i < res.length; i++) res[i] = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                res[i + j] += A[i] * B[j] % MOD;
            }
        }
        //for (int i = 0; i < res.length; i++) System.out.print(res[i] + " ");
        //System.out.println();
        //System.out.println();
        return fix(res);
    }

    public static long[] add(long[] A, long[] B) {
        long[] res = new long[Math.max(A.length, B.length)];
        int i = 0;
        for (i = 0; i < Math.min(A.length, B.length); i++) res[i] = A[i] + B[i];
        while (i < A.length) {
            res[i] = A[i];
            i++;
        }
        while (i < B.length) {
            res[i] = B[i];
            i++;
        }
        return fix(res);
    }

    public static long[] subtract(long[] A, long[] B) {
        long[] res = new long [Math.max(A.length, B.length)];
        int i;
        for (i = 0; i < Math.min(A.length, B.length); i++) res[i] = A[i] - B[i];
        while (i < A.length) {
            res[i] = A[i];
            i++;
        }
        while (i < B.length) {
            res[i] = -B[i];
            i++;
        }
        return fix(res);
    }

    public static long[] karatsuba(long[] A, long[] B) {
        //return multiply(A, B);
        if (A.length < 3 || B.length < 3) return multiply(A, B);
        int m = Math.min(A.length, B.length) / 2;
        long leftA[] = Arrays.copyOfRange(A, 0, m), rightA[] = Arrays.copyOfRange(A, m, A.length);
        long leftB[] = Arrays.copyOfRange(B, 0, m), rightB[] = Arrays.copyOfRange(B, m, B.length);
        long[] z0 = karatsuba(leftA, leftB);
        //System.out.println("_______");
        //printPolynomial(z0);
        //printPolynomial(multiply(leftA, leftB));
        //_assert(Arrays.equals(z0, multiply(leftA, leftB)));
        //System.out.println("_______");
        long[] z1 = karatsuba(rightA, rightB);
        long[] z2 = subtract(karatsuba(add(leftB, rightB), add(leftA, rightA)), add(z0, z1));
        return add(z0, add(addZero(z1, 2 * m), addZero(z2, m)));
    }
}
