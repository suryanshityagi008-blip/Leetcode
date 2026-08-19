class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited,
                        int x, int y, int px, int py, char ch) {

        if (visited[x][y]) {
            return true;
        }

        visited[x][y] = true;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length
                    && grid[nx][ny] == ch) {

                // Skip the parent cell
                if (nx == px && ny == py) continue;

                if (dfs(grid, visited, nx, ny, x, y, ch)) {
                    return true;
                }
            }
        }

        return false;
    }
}
    