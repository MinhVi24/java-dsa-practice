/** Prefix sums: answer range-sum queries in O(1) after O(n) preprocessing. */
public class PrefixSum {
    private final long[] prefix;

    public PrefixSum(int[] a) {
        prefix = new long[a.length + 1];
        for (int i = 0; i < a.length; i++) prefix[i + 1] = prefix[i] + a[i];
    }

    /** Sum of a[from..to], both ends inclusive. */
    public long rangeSum(int from, int to) {
        return prefix[to + 1] - prefix[from];
    }

    public static void main(String[] args) {
        PrefixSum ps = new PrefixSum(new int[]{3, -2, 5, 1, 4});
        System.out.println(ps.rangeSum(0, 4)); // 11
        System.out.println(ps.rangeSum(1, 3)); // 4
    }
}
