class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // recursive using dfs
        int n = numCourses;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int a = edge[0];
            int b = edge[1];

            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        boolean[] visiting = new boolean[n]; // current recursion stack
        ordering = new int[n];
        idx = n - 1;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                boolean res = dfs(graph, visited, visiting, i);

                if(res == false) return new int[0];
            }
        }

        // for(int i=0; i<n; i++){
        //     System.out.print(ordering[i] + " "); 
        // }
        // System.out.println();

        return ordering;
        
    }

    public int[] ordering; // topological ordering    
    public int idx;

    public boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] visiting, int src){
        if(visiting[src] == true) return false;

        visiting[src] = true;
        
        for(int child : graph.get(src)){
            if(!visited[child]){
                boolean rr = dfs(graph, visited, visiting, child);
                if(rr == false) return false;
            }
        }

        visiting[src] = false;
        visited[src] = true;
        ordering[idx] = src;
        idx--;
        return true;
    }


    /**
      (a,b): b -> a


      0 -> 1 -> 3
      |  
      2 
    
     */
}