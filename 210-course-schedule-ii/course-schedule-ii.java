class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // recursive using dfs
        int n = numCourses;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        // (a,b) b -> a
        for(int[] edge : prerequisites){
            int a = edge[0];
            int b = edge[1];

            graph.get(b).add(a);
            indegree[a] = indegree[a] + 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        if(queue.size() == 0) return new int[0];
        
        int[] ordering = new int[n];
        int idx = 0;
        
        while(queue.size() > 0){
            int rem = queue.remove();

            ordering[idx] = rem;
            idx++;

            for(int child : graph.get(rem)){
                indegree[child]--;
                if(indegree[child] == 0){
                    queue.add(child);
                }
            }
        } 

        if(idx == n) return ordering;
        else return new int[0];
    }
}