class Solution {
    public int jump(int[] nums) {
        int farthestWeCanGo = 0;
        int jumps = 0;
        int helper = 0;
       
        if(nums.length == 1) return 0;

        for(int i=0; i<nums.length - 1; i++){
            int temp =  i + nums[i];

            if(temp > farthestWeCanGo){
                farthestWeCanGo = temp;
            }

            if(i == helper){
                jumps++;
                helper = farthestWeCanGo;
            }
        }

        return jumps;
    }
}