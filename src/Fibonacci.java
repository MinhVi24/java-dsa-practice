import java.util.HashMap;
import java.util.Map;

/** Fibonacci: plain recursion is O(2^n); memoization and bottom-up are O(n). */
public class Fibonacci {
    private static final Map<Integer, Long> memo = new HashMap<>();

    public static long memoized(int n) {
        if (n < 2) return n;
        Long cached = memo.get(n);
        if (cached != null) return cached;
        long value = memoized(n - 1) + memoized(n - 2);
        memo.put(n, value);
        return value;
    }

    public static long bottomUp(int n) {
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            long t = a + b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(memoized(50)); // 12586269025
        System.out.println(bottomUp(90)); // 2880067194370816120
    }
}
