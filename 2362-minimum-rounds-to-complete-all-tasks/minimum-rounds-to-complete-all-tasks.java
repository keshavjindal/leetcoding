class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<tasks.length; i++){
            map.put(tasks[i] , map.getOrDefault(tasks[i],0) + 1);
        }

        List<Integer> values = new ArrayList<>(map.values());
        int[] dp = minLengthForGivenVal(Collections.max(values));
        int ans = 0;
        for(int val : values){
            if(dp[val] == -1) return -1;
            ans += dp[val];
        }
        return ans;
    }

    public int[] minLengthForGivenVal(int n){
        if(n <= 3) n += 7;
        
        int[] dp = new int[n + 1];

        dp[0] = -1;
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = 1;
        
        for(int i=4; i<=n; i++){
            int cont1 = dp[i - 2] == -1 ? Integer.MAX_VALUE : dp[i - 2];
            int cont2 = dp[i - 3] == -1 ? Integer.MAX_VALUE : dp[i - 3];

            dp[i] = Math.min(cont1 , cont2) + 1;
        }

        return dp;
    }
}