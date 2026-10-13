class Solution {
    private int[][] dir = new int[][]{{0,1},{1,0}};
    private int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return move(m, n, 0, 0);
    }

    private int move(int m, int n,  int r, int c){
        if(r == m-1 || c == n-1) return 1;

        if(r >= m || c>=n){
            return 0;
        }

        if(memo[r][c]!=0){
            return memo[r][c];
        }

        int totalMoves = 0;
        for(int[] d:dir){
            int nextRow = r + d[0];
            int nextCol = c + d[1];
            totalMoves += move(m, n, nextRow, nextCol);
        }

        memo[r][c] = totalMoves;
        return totalMoves;
    }
}