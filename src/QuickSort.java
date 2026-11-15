import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/** Quick sort with a random pivot (Lomuto partition). Average O(n log n), in place. */
public class QuickSort {
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        while (lo < hi) {
            int p = partition(a, lo, hi);
            // recurse into the smaller half so the stack depth stays O(log n)
            if (p - lo < hi - p) { sort(a, lo, p - 1); lo = p + 1; }
            else { sort(a, p + 1, hi); hi = p - 1; }
        }
    }

    private static int partition(int[] a, int lo, int hi) {
        swap(a, ThreadLocalRandom.current().nextInt(lo, hi + 1), hi);
        int pivot = a[hi], i = lo;
        for (int j = lo; j < hi; j++) if (a[j] < pivot) swap(a, i++, j);
        swap(a, i, hi);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {3, -1, 8, 8, 0, 42, 7, 1};
        sort(a);
        System.out.println(Arrays.toString(a)); // [-1, 0, 1, 3, 7, 8, 8, 42]
    }
}
