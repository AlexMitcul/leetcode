public class MinimumNumberofDaystoDisconnectIsland {

    void dfs(int[][] map, int x, int y, boolean[][] seen) {
        seen[x][y] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length && !seen[newX][newY] && map[newX][newY] == 1) {
                dfs(map, newX, newY, seen);
            }
        }
    }

    private int countIslands(int[][] map) {
        boolean[][] seen = new boolean[map.length][map[0].length];
        int islands = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1 && !seen[i][j]) {
                    islands++;
                    dfs(map, i, j, seen);
                }
            }
        }

        return islands;
    }

    public int minDays(int[][] grid) {
        if (countIslands(grid) != 1) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (countIslands(grid) != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

}
