class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
            we need to return the topological ordering of the graph.
            DAG's
        */
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : prerequisites){
            int a = e[0];
            int b = e[1];
            
            // b -> a
            graph.get(b).add(a);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        ans = new int[numCourses];
        idx = numCourses - 1;
        cycleFound = 0;
        
        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                dfs(graph, visited, recStack, i);
                if(cycleFound == 1){
                    return new int[0];
                }
            }
        }
        
        return ans;
    }
    
    public int[] ans;
    public int idx;
    public int cycleFound;
    
    public void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] recStack, int src){
        if(cycleFound == 1) return;
        
        visited[src] = true;
        recStack[src] = true;
        
        for(int nbr : graph.get(src)){
            if(visited[nbr] && recStack[nbr]){
                cycleFound = 1;
                return;
            }
            
            if(!visited[nbr]){
                dfs(graph, visited, recStack, nbr);
            }
        }
        
        recStack[src] = false;
        ans[idx] = src;
        idx--;
    }
}