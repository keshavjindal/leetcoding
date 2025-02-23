class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] helper = new boolean[nums.length];
        ans = new ArrayList<>();

        solve(nums, new ArrayList<>(), helper);
        return ans;
    }

    public List<List<Integer>> ans;

    public void solve(int[] nums, List<Integer> list, boolean[] helper){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(helper[i] == false){
                helper[i] = true;
                list.add(nums[i]);
                solve(nums,list,helper);
                helper[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}