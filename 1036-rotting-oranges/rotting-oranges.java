class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<pair> pq = new ArrayDeque<pair>();
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    // rotten orange
                    pq.add(new pair(i, j, grid[i][j]));
                }
            }
        }

        int pqInitSize = pq.size();

        int ans = 0;
        while(pq.size() > 0){
            int size = pq.size();
            boolean orangeRotted = false;
            while(size > 0){
                pair rem = pq.remove();

                int i = rem.i;
                int j = rem.j;

                if(i + 1 < m && grid[i + 1][j] == 1){
                    grid[i + 1][j] = 2;
                    pq.add(new pair(i + 1, j, 2));
                    orangeRotted = true;
                }

                if(i - 1 >= 0 && grid[i - 1][j] == 1){
                    grid[i - 1][j] = 2;
                    pq.add(new pair(i - 1, j, 2));
                    orangeRotted = true;
                }

                if(j + 1 < n && grid[i][j + 1] == 1){
                    grid[i][j + 1] = 2;
                    pq.add(new pair(i, j + 1, 2));
                    orangeRotted = true;
                }

                if(j - 1 >= 0 && grid[i][j - 1] == 1){
                    grid[i][j - 1] = 2;
                    pq.add(new pair(i, j - 1, 2));
                    orangeRotted = true;
                }
                
                size--;
            }

            if(orangeRotted = true){
                ans++;
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    // fresh orange
                    return -1;
                }
            }
        }

        if(pqInitSize == 0) return 0;

        return ans - 1;
    }

    public class pair{
        int i;
        int j;
        int val;

        pair(int i, int j, int val){
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
}