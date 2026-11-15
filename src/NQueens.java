/** N-Queens: count the ways to place n queens so that no two attack each other (backtracking). */
public class NQueens {
    public static int count(int n) {
        return place(0, n, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
    }

    private static int place(int row, int n, boolean[] cols, boolean[] diag, boolean[] anti) {
        if (row == n) return 1;
        int total = 0;
        for (int c = 0; c < n; c++) {
            int d = row - c + n - 1, a = row + c;
            if (cols[c] || diag[d] || anti[a]) continue;
            cols[c] = diag[d] = anti[a] = true;
            total += place(row + 1, n, cols, diag, anti);
            cols[c] = diag[d] = anti[a] = false;
        }
        return total;
    }

    public static void main(String[] args) {
        for (int n = 1; n <= 8; n++) System.out.println(n + " -> " + count(n)); // 1, 0, 0, 2, 10, 4, 40, 92
    }
}
