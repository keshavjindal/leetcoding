class Solution {
    public String maximumOddBinaryNumber(String s) {
        String ans = "";

        int ones = 0;
        int zeroes = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                ones++;
            }else{
                zeroes++;
            }
        }   

        // System.out.println(zeroes);
        //         System.out.println(ones);

        for(int i=0; i<ones-1; i++){
            ans += "1";
        }

        for(int i=0; i<zeroes; i++){
            ans += "0";
        }

        ans += "1";
        return ans;
    }
}