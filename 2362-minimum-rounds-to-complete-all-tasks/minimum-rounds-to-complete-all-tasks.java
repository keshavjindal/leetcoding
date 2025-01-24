class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<tasks.length; i++){
            map.put(tasks[i] , map.getOrDefault(tasks[i],0) + 1);
        }

        List<Integer> values = new ArrayList<>(map.values());
        int ans = 0;
        for(int val : values){
            if(val == 1) return -1;

            int rem = val % 3;

            if(rem == 0) ans += (val / 3);
            else ans += 1 + (val/3);            
        }
        return ans;
    }
}