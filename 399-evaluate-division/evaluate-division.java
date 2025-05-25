class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];

        HashMap<String,HashMap<String,Double>> map = new HashMap<>();

        for(int i=0; i<equations.size(); i++){
            List<String> eqn = equations.get(i);
            double wt = values[i];

            String u = eqn.get(0);
            String v = eqn.get(1);

            if(!map.containsKey(u)) map.put(u , new HashMap<>());
            if(!map.containsKey(v)) map.put(v , new HashMap<>());

            map.get(u).put(v , wt);
            map.get(v).put(u , 1.0/wt);
        }

        int idx = 0;
        for(List<String> query : queries){
            String from = query.get(0);
            String to = query.get(1);

            if((!map.containsKey(from)) || (!map.containsKey(to))){
                ans[idx] = -1.0;
            }
            else{
                ans[idx] = bfs(map, from , to);
            }
            idx++;
        }

        return ans;
    }

    public double bfs(HashMap<String,HashMap<String,Double>> graph, String from, String to){
        HashSet<String> visited = new HashSet<>();
        Queue<pair> queue = new LinkedList<>();

        queue.add(new pair(from , 1.0));

        while(queue.size() > 0){
            pair rem = queue.remove();

            if(visited.contains(rem.str)) continue;

            if(rem.str.equals(to)){
                return rem.val;
            }

            visited.add(rem.str);
            HashMap<String,Double> children = graph.get(rem.str);

            for(String child : children.keySet()){
                double val = children.get(child);
                if(!visited.contains(child)){
                    queue.add(new pair(child , rem.val * val));
                }
            }
        }

        return -1.0;
    }

    public class pair{
        String str;
        double val;

        pair(String str, double val){
            this.str = str;
            this.val = val;
        }
    }
}