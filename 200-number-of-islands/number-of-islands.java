class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    helper(grid, i, j);
                }
            }
        }

        return ans;
    }

    public void helper(char[][] grid, int i, int j){
        if(i < 0 || j < 0) return;
        if(i >= grid.length || j >= grid[0].length) return;

        if(grid[i][j] == '0') return;

        grid[i][j] = '0';

        helper(grid, i + 1, j);
        helper(grid, i, j + 1);
        helper(grid, i, j - 1);
        helper(grid, i - 1, j);
    }
}