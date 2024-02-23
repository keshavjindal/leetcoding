class Solution {
    public int minDistance(String word1, String word2) {
        /*
            horse
            ros
        */   
        
        dp = new int[word1.length() + 10][word2.length() + 10];
        
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }
        
        return solve(word1, word2, 0, 0);
    }
    
    public int[][] dp;
    
    public int solve(String word1, String word2, int i, int j){
        if(i == word1.length()){
            return word2.length() - j;
        }
        
        if(j == word2.length()){
            return word1.length() - i;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        char ch1 = word1.charAt(i);
        char ch2 = word2.charAt(j);
        
        if(ch1 == ch2){
            int ans = solve(word1, word2, i + 1, j + 1);
            return dp[i][j] = ans;
        }
        else{
            // insert
            int cont1 = 1 + solve(word1 , word2, i, j + 1);
            
            // replace
            int cont2 = 1 + solve(word1 , word2, i + 1, j + 1);
            
            // delete
            int cont3 = 1 + solve(word1 , word2, i + 1, j);
            
            int ans = Math.min(Math.min(cont1 , cont2) , cont3);
            

            
            return dp[i][j] = ans;
        }
    }
}