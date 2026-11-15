/** Greatest common divisor (Euclid's algorithm) and least common multiple. */
public class GcdLcm {
    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a / gcd(a, b) * b); // divide first to avoid overflow
    }

    public static void main(String[] args) {
        System.out.println(gcd(84, 36)); // 12
        System.out.println(lcm(4, 6));   // 12
        System.out.println(lcm(21, 6));  // 42
    }
}
