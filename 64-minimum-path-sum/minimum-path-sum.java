class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m + 10][n + 10];
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }

        return solve(grid , 0 , 0);
    }

    public int[][] dp;

    // whats the min path sum if we go from (i,j)
    // to bottom right, only using R(right) and D(down) steps
    public int solve(int[][] matrix, int i, int j){
        if(i == matrix.length - 1 && j == matrix[0].length - 1) return matrix[i][j];
        if(i >= matrix.length || j >= matrix[0].length) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        int rr1 = solve(matrix, i, j + 1); // go right
        int rr2 = solve(matrix, i + 1, j); // go down

        return dp[i][j] = matrix[i][j] + Math.min(rr1 , rr2);
    }
}