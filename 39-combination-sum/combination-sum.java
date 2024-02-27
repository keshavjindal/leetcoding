class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        
        solve(candidates , 0 , target , new ArrayList<>());
        
        return ans;
    }
    
    List<List<Integer>> ans;
    
    public void solve(int[] arr, int i, int target, List<Integer> list){
        if(target < 0) return;
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        if(i == arr.length) return;
        
        list.add(arr[i]);
        solve(arr , i , target - arr[i], list);
        
        list.remove(list.size() - 1);
        solve(arr, i + 1, target, list);
    }
}