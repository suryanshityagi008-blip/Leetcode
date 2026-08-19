class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        
        Map<Integer, int[][]> directions = new HashMap<>();
        directions.put(1, new int[][]{{0, -1}, {0, 1}});
        directions.put(2, new int[][]{{-1, 0}, {1, 0}});
        directions.put(3, new int[][]{{0, -1}, {1, 0}});
        directions.put(4, new int[][]{{0, 1}, {1, 0}});
        directions.put(5, new int[][]{{0, -1}, {-1, 0}});
        directions.put(6, new int[][]{{0, 1}, {-1, 0}});

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
           if (x == m - 1 && y == n - 1) return true;

            for (int[] dir : directions.get(grid[x][y])) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {

                    // reverse connection check
                    for (int[] back : directions.get(grid[nx][ny])) {
                        if (back[0] == -dir[0] && back[1] == -dir[1]) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                            break;
                        }
                    }
                }
            }
        }

        return false;
    }
}
