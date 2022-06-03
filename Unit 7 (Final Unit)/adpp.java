import java.io.*;
import java.util.*;

public class adpp {
    public static final Scanner sc = new Scanner(System.in);
    public static final int MAX_VAL = (int)Math.pow(10, 3); // Constant for highest value (used for frequency array)
    public static final long MOD =  998244353;
    public static void main(String[] args) {
        int N = sc.nextInt();
        long K = sc.nextLong();
        int Q = sc.nextInt();
        long[] freq = new long[MAX_VAL + 1]; // Initialize frequency array
        for (int i = 0; i <= MAX_VAL; i++) freq[i] = 0; // Set frequency array to 0
        for (int i = 0; i < N; i++) freq[sc.nextInt()]++; // Build frequency array
        freq[0] = 1; // Set frequency of 0 to 1 since there's 1 way to pick 0 coins
        /*
            Freq stores the generating function of the coin with the ith index storing the coefficient of the ith power. For example,
            (1x^0+1x+1x^2) for the sample input. The coefficient indicates the number of ways to achieve the ith power and the ith power indicates the number of coins.
            Since there are K rounds, we raise this polynomial to the power of K, ensuring that the size of the polynomial does not exceed MAX_VAL + 1.
            
        */
        long[] ans = new long[MAX_VAL + 1]; // Create answer array
        boolean gone = false;
        while (K > 0) { // Binary exponeniate the polynomial to solve in log(K) time (normally K time)
            if (K % 2 > 0) {
                if (!gone) {
                    ans = Arrays.copyOfRange(freq, 0, MAX_VAL + 1);
                    gone = true;
                }
                else {
                    long[] res = karatsuba(ans, freq); // Multiply the 2 polynomials using Karatsuba
                    ans = Arrays.copyOfRange(res, 0, MAX_VAL + 1); // Take only the first MAX_VAL + 1 elements
                }
            }
            long[] prodRes = karatsuba(freq, freq); // Exponentiate the base
            freq = Arrays.copyOfRange(prodRes, 0, MAX_VAL + 1);  // Take only the first MAX_VAL + 1 elements
            K >>= 1; // Essentially, floor division by 2
        }
        long[] psa = new long[MAX_VAL + 1];
        psa[0] = ans[0];
        for (int i = 1; i <= MAX_VAL; i++) psa[i] = (psa[i - 1] + ans[i]) % MOD; // Calculate PSA (prefix sum array) of the coefficients to answer queries efficiently
        for (int i = 0; i < Q; i++) {
            int L = sc.nextInt(), R = sc.nextInt();
            System.out.println((psa[R] - ((L == 0) ? 0 : psa[L - 1]) + MOD) % MOD); // Output answer
        }
        return;
    }

    // Helper function to debug (Java assert is disabled)
    public static void _assert(boolean condition) {
        if (!condition) throw new RuntimeException("Assert failed!");
        return;
    }

    // Function to pad a polynomial A with zeros
    public static long[] addZero(long[] A, int m) {
        long[] res = new long[A.length + m];
        for (int i = 0; i < m; i++) res[i] = 0;
        for (int i = m; i < A.length + m; i++) res[i] = A[i - m];
        return res;
    }

    // Function to make arrays elements in the range [0, MOD)
    public static long[] fix(long[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] += MOD; // Numbers after subtraction can be < 0 (element of [-MOD + 1, -1]), so move it back into the range [0, MOD)
            _assert(A[i] >= 0); // Numbers should always be >= 0
            A[i] %= MOD; // Take the number under MOD to ensure that it doesn't overflow
        }
        return A;
    }

    // Function to naively multiply two polynomials
    public static long[] multiply(long[] A, long[] B) {
        long res[] = new long[A.length + B.length - 1];
        for (int i = 0; i < res.length; i++) res[i] = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                res[i + j] += A[i] * B[j] % MOD;
            }
        }
        return fix(res);
    }

    // Function to add two add two polynomials
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

    // Function to subtract two polynomials
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

    // Function to multiply two polynomials efficiently in ~O(N^{log_{2}3})~ time (approximately N^{1.5})
    public static long[] karatsuba(long[] A, long[] B) {
        if (A.length < 3 || B.length < 3) return multiply(A, B); // Base case: multiply the polynomials naively
        int m = Math.min(A.length, B.length) / 2; // Get half length
        // Divide the array into 4 relevant segments
        long leftA[] = Arrays.copyOfRange(A, 0, m), rightA[] = Arrays.copyOfRange(A, m, A.length);
        long leftB[] = Arrays.copyOfRange(B, 0, m), rightB[] = Arrays.copyOfRange(B, m, B.length);
        // Call Karatsuba on the new, smaller arrays
        long[] z0 = karatsuba(leftA, leftB);
        long[] z1 = karatsuba(rightA, rightB);
        long[] z2 = subtract(karatsuba(add(leftB, rightB), add(leftA, rightA)), add(z0, z1));
        // Pad the final answer accordingly with zeros
        return add(z0, add(addZero(z1, 2 * m), addZero(z2, m)));
    }
}
