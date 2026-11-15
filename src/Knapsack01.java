/** 0/1 knapsack: max total value with total weight <= capacity. O(n * W) time, O(W) space. */
public class Knapsack01 {
    public static int maxValue(int[] weight, int[] value, int capacity) {
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < weight.length; i++)
            for (int w = capacity; w >= weight[i]; w--) // go backwards so each item is used at most once
                dp[w] = Math.max(dp[w], dp[w - weight[i]] + value[i]);
        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 5};
        int[] value = {1, 4, 5, 7};
        System.out.println(maxValue(weight, value, 7)); // 9 (weights 3 + 4)
    }
}
