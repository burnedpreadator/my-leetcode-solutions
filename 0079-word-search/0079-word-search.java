class Solution {
    private static final int[][] MOVES = {
        {0,1},
        {0,-1},
        {-1,0},
        {1,0}
    };

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(board[r][c] == word.charAt(0)){
                    if(dfs(board, r, c, word, 0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int index){
        if(index == word.length()){
            return true;
        }

        //boundary conditions
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!=word.charAt(index)){
            return false;
        }

        char temp = board[r][c];
        board[r][c]='#';

        for(int[] move: MOVES){
            int nextRow = r + move[0];
            int nextCol = c + move[1];

            if(dfs(board, nextRow, nextCol, word, index+1)){
                return true;
            }
        }

        board[r][c] = temp;

        return false;
        
    }
}