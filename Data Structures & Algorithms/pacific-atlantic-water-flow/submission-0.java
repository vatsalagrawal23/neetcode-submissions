class Solution {
    public class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public boolean[][] bfs(int[][] heights, Queue<Pair> p, boolean[][] vis) {
        int dx[] = {-1, 0, 0, 1};
        int dy[] = {0, -1, 1, 0};
        int n = heights.length;
        int m = heights[0].length;
        while(!p.isEmpty()) {
            Pair pos = p.poll();
            int cur = heights[pos.x][pos.y];
            for(int i = 0; i < 4; i++) {
                int r = dx[i] + pos.x;
                int c = dy[i] + pos.y;
                if(r < 0 || c < 0 || r >= n || c >= m || vis[r][c] || heights[r][c] < cur) {
                    continue;
                }
                else {
                    vis[r][c] = true;
                    p.add(new Pair(r, c));
                }
            }
        }

        return vis;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        boolean vis1[][] = new boolean[n][m];
        Queue<Pair> q1 = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            vis[0][i] = true;
            q.add(new Pair(0, i));

            vis1[n-1][i] = true;
            q1.add(new Pair(n-1, i));
        }
        for(int i = 0; i < n; i++) {
            vis[i][0] = true;
            q.add(new Pair(i, 0));

            vis1[i][m-1] = true;
            q1.add(new Pair(i, m-1));
        }

        vis = bfs(heights, q, vis);
        vis1 = bfs(heights, q1, vis1);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] && vis1[i][j]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    ans.add(tmp);
                }
            }
        }

        return ans;
    }
}
