import java.util.Arrays;

/** Merge sort: stable, O(n log n) time, O(n) extra space. */
public class MergeSort {
    public static void sort(int[] a) {
        if (a.length < 2) return;
        sort(a, new int[a.length], 0, a.length - 1);
    }

    private static void sort(int[] a, int[] tmp, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) >>> 1;
        sort(a, tmp, lo, mid);
        sort(a, tmp, mid + 1, hi);
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) tmp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= mid) tmp[k++] = a[i++];
        while (j <= hi) tmp[k++] = a[j++];
        System.arraycopy(tmp, lo, a, lo, hi - lo + 1);
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 5, 6, -3};
        sort(a);
        System.out.println(Arrays.toString(a)); // [-3, 1, 2, 5, 5, 6, 9]
    }
}
