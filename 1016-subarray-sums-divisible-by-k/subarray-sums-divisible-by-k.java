class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        int n = arr.length;

        int[] psum = new int[n];
        for(int i=0; i<n; i++){
            if(i == 0){
                psum[0] = arr[0];
            }
            else{
                psum[i] = psum[i - 1] + arr[i];
            }
        }

        for(int i=0; i<n; i++){
            psum[i] = psum[i] % k;
            if(psum[i] < 0) psum[i] += k;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0 , 1);
        int ans = 0;
        for(int i=0; i<n; i++){
            if(map.containsKey(psum[i])){
                ans += map.get(psum[i]);
            }

            map.put(psum[i] , map.getOrDefault(psum[i] , 0) + 1);
        }
        return ans;
    }
}