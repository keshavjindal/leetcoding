class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        dp = new int[m + 10][n + 10];
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }
        
        return solve(grid, 0, 0);
    }
    
    public int[][] dp;
    
    public int solve(int[][] grid, int i, int j){
        if(i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        if(i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        
        int rr1 = solve(grid, i, j + 1);
        int rr2 = solve(grid, i + 1, j);
        
        return dp[i][j] = grid[i][j] + Math.min(rr1 , rr2);
    }
}