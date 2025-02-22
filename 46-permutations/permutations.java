class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }

        return solve(list);
    }

    public List<List<Integer>> solve(List<Integer> list){
        if(list.size() == 1){
            List<List<Integer>> br = new ArrayList<>();
            List<Integer> br_list = new ArrayList<>();
            br_list.add(list.get(0));
            br.add(br_list);
            return br;
        }

        List<List<Integer>> mr = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            int curr_ele = list.get(i);
            List<Integer> rem_list = new ArrayList<>();
            for(int j=0; j<list.size(); j++){
                if(j != i){
                    rem_list.add(list.get(j));
                }
            }

            List<List<Integer>> rr = solve(rem_list);

            for(List<Integer> rr_list : rr){
                List<Integer> new_list = new ArrayList<>();
                new_list.add(curr_ele);
                for(int j=0; j<rr_list.size(); j++){
                    new_list.add(rr_list.get(j));
                }
                mr.add(new_list);
            }
        }

        return mr;
    }
}