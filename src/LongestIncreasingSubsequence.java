import java.util.Arrays;

/** Length of the longest strictly increasing subsequence in O(n log n) (patience sorting). */
public class LongestIncreasingSubsequence {
    public static int length(int[] nums) {
        int[] tails = new int[nums.length]; // tails[i] = smallest tail of an increasing run of length i + 1
        int size = 0;
        for (int x : nums) {
            int i = Arrays.binarySearch(tails, 0, size, x);
            if (i < 0) i = -(i + 1);
            tails[i] = x;
            if (i == size) size++;
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(length(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4
        System.out.println(length(new int[]{7, 7, 7, 7}));                 // 1
    }
}
