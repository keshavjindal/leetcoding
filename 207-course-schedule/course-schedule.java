class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // we need to detect cycle in the directed graph
        // if cycle found, return false; else return true
        /*
        
            0 ----> 1 ----> 2 ----> 0
            
            
            
        */
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : prerequisites){
            int a = edge[0];
            int b = edge[1];
            
            // b -> a
            graph.get(b).add(a);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        
        for(int i=0; i<numCourses; i++){
            if(visited[i] == false){
                boolean val = solve(graph, visited, recStack, i); 
                if(val == true) return false;
            }
        }
        return true;
    }
    
    public boolean solve(ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] recStack, int src)
  {
        visited[src] = true;
        recStack[src] = true;
        
        for(int nbr : graph.get(src)){
            if(visited[nbr] == false){
                if(solve(graph, visited, recStack, nbr) == true){
                    return true;
                }
            }
            else if(recStack[nbr] == true){
                return true;
            }
        }
        
        recStack[src] = false;
        return false;
    }
}