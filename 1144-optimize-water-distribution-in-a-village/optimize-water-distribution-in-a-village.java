class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // make graph 

        // size: n houses + 1 (for # node)
        ArrayList<ArrayList<pair>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        // connecting every village to # node
        for(int i=1; i<=n; i++){
            graph.get(i).add(new pair(0 , wells[i - 1]));
            graph.get(0).add(new pair(i , wells[i - 1]));
        }

        for(int[] pipe : pipes){
            int u = pipe[0];
            int v = pipe[1];
            int wt = pipe[2];
            graph.get(u).add(new pair(v , wt));
            graph.get(v).add(new pair(u , wt));
        }

        // prims algo
        PriorityQueue<pair> pq = new PriorityQueue<>();
        int cost = 0;
        pq.add(new pair(0 , 0));
        boolean[] visited = new boolean[n + 1];

        while(pq.size() > 0){
            pair rem = pq.remove();

            if(visited[rem.src] == true) continue;

            visited[rem.src] = true;
            cost += rem.val;

            for(pair child : graph.get(rem.src)){
                if(visited[child.src] == false){
                    pq.add(child);
                }
            }
        }

        return cost;
    }

    public class pair implements Comparable<pair>
    {
        int src;
        int val;

        pair(int src, int val){
            this.src = src;
            this.val = val;
        }

        public int compareTo(pair other){
            return this.val - other.val;
        }
    }
}