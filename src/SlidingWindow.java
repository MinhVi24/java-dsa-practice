import java.util.HashMap;
import java.util.Map;

/** Sliding window: max sum of k consecutive elements; longest substring without repeating characters. */
public class SlidingWindow {
    public static long maxSumOfK(int[] a, int k) {
        if (k <= 0 || k > a.length) throw new IllegalArgumentException("k out of range");
        long window = 0;
        for (int i = 0; i < k; i++) window += a[i];
        long best = window;
        for (int i = k; i < a.length; i++) {
            window += a[i] - a[i - k];
            best = Math.max(best, window);
        }
        return best;
    }

    public static int longestUniqueSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int best = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer prev = last.put(s.charAt(i), i);
            if (prev != null && prev >= start) start = prev + 1;
            best = Math.max(best, i - start + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxSumOfK(new int[]{2, 1, 5, 1, 3, 2}, 3)); // 9
        System.out.println(longestUniqueSubstring("abcabcbb"));         // 3
        System.out.println(longestUniqueSubstring("pwwkew"));           // 3
    }
}
