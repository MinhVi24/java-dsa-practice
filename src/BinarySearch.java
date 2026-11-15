/** Binary search on a sorted array, plus lower bound (first index with a[i] >= x). O(log n). */
public class BinarySearch {
    public static int search(int[] a, int x) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == x) return mid;
            if (a[mid] < x) lo = mid + 1; else hi = mid - 1;
        }
        return -1;
    }

    public static int lowerBound(int[] a, int x) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < x) lo = mid + 1; else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 3, 5, 8, 13};
        System.out.println(search(a, 8));      // 4
        System.out.println(search(a, 4));      // -1
        System.out.println(lowerBound(a, 3));  // 1
        System.out.println(lowerBound(a, 20)); // 6
    }
}
