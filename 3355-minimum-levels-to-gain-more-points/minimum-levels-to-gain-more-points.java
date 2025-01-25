class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length;

        int[] prefix = new int[n];
        prefix[0] = possible[0] == 0 ? -1 : possible[0];
        for(int i=1; i<n; i++){
            int val = possible[i] == 0 ? -1 : possible[i];
            prefix[i] = prefix[i - 1] + val;
        }

        int[] suffix = new int[n];
        suffix[n - 1] = possible[n - 1] == 0 ? -1 : possible[n - 1];
        for(int i=n-2; i>=0; i--){
            int val = possible[i] == 0 ? -1 : possible[i];
            suffix[i] = suffix[i + 1] + val;
        }

        for(int i=0; i<=n-2; i++){
            if(prefix[i] > suffix[i + 1]) return i + 1;
        }

        return -1;
    }

    // 1 -1 1 -1

    // 1 0 1 0
    // 0  -1  0  -1
}