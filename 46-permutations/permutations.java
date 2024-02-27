class Solution {
    public List<List<Integer>> permute(int[] nums) {
        /*
         1, 2, 3
         
         list -> 
            1
            1 2
            1 2 3
            1
            
        */
        
        ans = new ArrayList<>();
        helper = new boolean[nums.length];
        solve(nums , new ArrayList<>());
        return ans;
    }
    
    public List<List<Integer>> ans;
    public boolean[] helper;
    
    public void solve(int[] arr, List<Integer> list){
        if(list.size() == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            if(helper[i] == false){
                helper[i] = true;
                list.add(arr[i]);
                
                solve(arr , list);
                
                helper[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}