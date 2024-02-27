class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        visited = new boolean[m][n];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    solve(board, i, j, word, 0);
                    if(ans == true){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean[][] visited;
    public boolean ans;
    
    public void solve(char[][] board, int i, int j, String word, int idx){
        if(i >= board.length || i < 0 || j < 0 || j >= board[0].length) return;
        if(visited[i][j] == true) return;
        
        if(idx == word.length() - 1){
            if(board[i][j] == word.charAt(idx)){
                ans = true;
                return;
            }  
            else{
                return;
            }
        }
        
        if(board[i][j] != word.charAt(idx)) return;
        
        if(ans == true){
            return;
        }
        
        visited[i][j] = true;
        
        solve(board, i, j + 1, word, idx + 1); 
        solve(board, i + 1, j, word, idx + 1);
        solve(board, i - 1, j, word, idx + 1);
        solve(board, i, j - 1, word, idx + 1);
        
        visited[i][j] = false;
    }
}