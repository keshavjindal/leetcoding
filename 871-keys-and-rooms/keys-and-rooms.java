class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
          
        int n = rooms.size();
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        int idx = 0;
        for(List<Integer> list : rooms){
            for(int key : list){
                graph.get(idx).add(key);
            }
            idx++;
        }
        
        boolean[] visited = new boolean[n];
        dfs(graph, visited, 0);
        
        for(int i=0; i<n; i++){
            if(visited[i] == false){
                return false;
            }
        }
        
        return true;
    }
    
    public void dfs(List<List<Integer>> graph, boolean[] visited, int src){
        visited[src] = true;
        
        for(int child : graph.get(src)){
            if(visited[child] == false){
                dfs(graph, visited, child);
            }
        }
    }
}