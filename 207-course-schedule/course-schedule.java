class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // we can create a directed graph
        // and then we need to detect cycle in it
        // if cycle -> return false
        // no cycle -> return true

        // create graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        } 

        for(int[] edge : prerequisites){
            int a = edge[0];
            int b = edge[1];

            graph.get(b).add(a);
        }

        // detect cycle
        int[] visited = new int[numCourses];
        // 0 : not explored
        // 1 : being explored
        // 2 : fully explored
        for(int i=0; i<numCourses; i++){
            if(visited[i] == 0){
                boolean temp = solve(i, graph, visited);
                if(temp == false) return false;
            }
        }

        return true;
    }

    public boolean solve(int src, ArrayList<ArrayList<Integer>> graph, int[] visited){
        visited[src] = 1;
        ArrayList<Integer> children = graph.get(src);

        for(int child : children){
            if(visited[child] == 0){
                boolean temp = solve(child, graph, visited);
                if(temp == false) return false;
            }
            else if(visited[child] == 1){
                return false;
            }
        }

        visited[src] = 2;
        return true;
    }
}