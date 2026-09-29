class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if(heights == null || heights.length == 0 || heights[0].length == 0){
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacificReachable = new boolean[m][n];
        boolean[][] atlanticReachable = new boolean[m][n];

        for(int c=0; c<n; c++){
            dfs(0, c, heights, pacificReachable, heights[0][c]);
            dfs(m-1, c, heights, atlanticReachable, heights[m-1][c]);
        }

        for(int r=0; r<m; r++){
            dfs(r, 0, heights, pacificReachable, heights[r][0]);
            dfs(r, n-1, heights, atlanticReachable, heights[r][n-1]);
        }

        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(pacificReachable[r][c] && atlanticReachable[r][c]){
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] reachable, int prevheight){
        int m = heights.length;
        int n = heights[0].length;
        
        if(r<0 || r >= m || c < 0 || c >= n || reachable[r][c] || heights[r][c]<prevheight){
            return;
        }

        reachable[r][c] = true;
        dfs(r-1, c, heights, reachable, heights[r][c]);
        dfs(r+1, c, heights, reachable, heights[r][c]);
        dfs(r, c-1, heights, reachable, heights[r][c]);
        dfs(r, c+1, heights, reachable, heights[r][c]);
    }
}