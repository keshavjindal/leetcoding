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
        
        int[] indegree = new int[numCourses];
        
        for(int[] e : prerequisites){
            int a = e[0];
            int b = e[1];
            
            // b -> a
            graph.get(b).add(a);
            indegree[a] += 1;
        }
        
        // solve iteratively: kahn's algorithm
        // bfs
        int[] ans = new int[numCourses];
        int idx = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(queue.size() > 0){
            int rem = queue.remove();
            
            ans[idx] = rem;
            idx++;
            
            for(int nbr : graph.get(rem)){
                indegree[nbr] -= 1;
                if(indegree[nbr] == 0){
                    queue.add(nbr);
                }
            }
        }
        
        if(idx == numCourses) return ans;
        else return new int[0];
    }
}