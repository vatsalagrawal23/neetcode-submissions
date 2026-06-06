class Solution {
    public int x = 0;
    public void check(int[][] grid, int i, int j, int n, int m) {
        if(i < 0 || j < 0 || i >=n || j >= m) {
            return;
        }
        if(grid[i][j] == 1) {
            grid[i][j] = 0;
            x++;
            check(grid, i + 1, j, n, m);
            check(grid, i - 1, j, n, m);
            check(grid, i, j + 1, n, m);
            check(grid, i, j - 1, n, m);

        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    x = 0;
                    check(grid, i, j , n , m);
                    ans = Math.max(ans, x);
                }
            }
        }

        return ans;
    }
}
