import java.util.ArrayDeque;
import java.util.Arrays;

/** BFS shortest path on a grid from S to E ('#' = wall), moving up / down / left / right. */
public class GridShortestPath {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int shortestPath(String[] grid) {
        int rows = grid.length, cols = grid[0].length();
        int[][] dist = new int[rows][cols];
        for (int[] row : dist) Arrays.fill(row, -1);
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (grid[r].charAt(c) == 'S') {
                    dist[r][c] = 0;
                    queue.add(new int[]{r, c});
                }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (grid[cur[0]].charAt(cur[1]) == 'E') return dist[cur[0]][cur[1]];
            for (int[] d : DIRS) {
                int r = cur[0] + d[0], c = cur[1] + d[1];
                if (r < 0 || c < 0 || r >= rows || c >= cols) continue;
                if (grid[r].charAt(c) == '#' || dist[r][c] != -1) continue;
                dist[r][c] = dist[cur[0]][cur[1]] + 1;
                queue.add(new int[]{r, c});
            }
        }
        return -1; // E is unreachable
    }

    public static void main(String[] args) {
        String[] grid = {
            "S..#....",
            ".#.#.##.",
            ".#...#..",
            ".####.#.",
            "......#E"
        };
        System.out.println(shortestPath(grid)); // 15
    }
}
