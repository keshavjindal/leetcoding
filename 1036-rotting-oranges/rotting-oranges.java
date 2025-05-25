class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    // rotten
                    queue.add(new pair(i,j,0));
                }
            }
        }

        int ans = 0;
        while(queue.size() > 0){
            pair rem = queue.remove();

            int i = rem.i;
            int j = rem.j;

            if(visited[i][j] == true) continue;
            visited[i][j] = true;

            int min = rem.min;
            ans = Math.max(ans , min);

            helper(grid, i, j + 1, min + 1, queue, visited);
            helper(grid, i + 1, j, min + 1, queue, visited);
            helper(grid, i - 1, j, min + 1, queue, visited);
            helper(grid, i, j - 1, min + 1, queue, visited);       
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    // fresh
                    return -1;
                }
            }
        }

        return ans;
    }

    public void helper(int[][] grid, int i, int j, int min, Queue<pair> queue, boolean[][] visited){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }

        if(visited[i][j] == true) return;
        if(grid[i][j] != 1) return;

        grid[i][j] = 2;
        queue.add(new pair(i, j, min));
    }

    public class pair{
        int i;
        int j;
        int min;

        pair(int i, int j, int min){
            this.i = i;
            this.j = j;
            this.min = min;
        }

    }
}