class Solution {
    public int totalNQueens(int n) {
        ans = 0;
        solve(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return ans;
    }

    public int ans;

    public void solve(int row, int n, HashSet<Integer> cols, HashSet<Integer> diag, HashSet<Integer> antiDiag){
        if(row == n){
            ans++;
            return;
        }

        for(int col=0; col<n; col++){
            int d = row - col;
            int ad = row + col;

            if(cols.contains(col) || diag.contains(d) || antiDiag.contains(ad)) continue;

            cols.add(col);
            diag.add(d);
            antiDiag.add(ad);
            solve(row + 1 , n , cols , diag , antiDiag);
            cols.remove(col);
            diag.remove(d);
            antiDiag.remove(ad);
        }
    }
}