class Solution {
    public class Status {
        int x;
        int y;
        int d;
        public Status(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Status> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Status(i, j, 0));
                }
            }
        }
        int ans = 0;
        int dx[] = {-1, 0, 0, 1};
        int dy[] = {0, -1, 1, 0};
        while(!q.isEmpty()) {
            Status tmp = q.poll();
            ans = Math.max(ans, tmp.d);
            for(int i = 0; i < 4; i++) {
                int r = dx[i] + tmp.x;
                int c = dy[i] + tmp.y;
                if(r < 0 || c < 0 || r >=n || c >=m || grid[r][c] != 1) {
                    continue;
                }
                else {
                    Status st = new Status(r, c, tmp.d + 1);
                    q.add(st);
                    grid[r][c] = 2;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }
}
