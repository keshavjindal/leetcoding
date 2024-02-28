class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        visited = new boolean[m][n];
        
        int ans = 0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                char ch = grid[i][j];
                
                if(ch == '1'){
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return ans;
    }
    
    public boolean[][] visited;
    
    public void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if(grid[i][j] == '0') return;
        if(visited[i][j] == true) return;
        
        grid[i][j] = '0';
        visited[i][j] = true;
        
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}