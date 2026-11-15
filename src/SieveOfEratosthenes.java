import java.util.ArrayList;
import java.util.List;

/** Sieve of Eratosthenes: all primes <= n in O(n log log n). */
public class SieveOfEratosthenes {
    public static List<Integer> primesUpTo(int n) {
        List<Integer> primes = new ArrayList<>();
        if (n < 2) return primes;
        boolean[] composite = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (composite[i]) continue;
            primes.add(i);
            for (long j = (long) i * i; j <= n; j += i) composite[(int) j] = true;
        }
        return primes;
    }

    public static void main(String[] args) {
        System.out.println(primesUpTo(50));               // [2, 3, 5, 7, 11, ..., 47]
        System.out.println(primesUpTo(1_000_000).size()); // 78498
    }
}
