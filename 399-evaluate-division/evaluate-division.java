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
            HashSet<String> visited = new HashSet<>();
            String from = query.get(0);
            String to = query.get(1);

            if((!map.containsKey(from)) || (!map.containsKey(to))){
                ans[idx] = -1.0;
            }
            else{
                ans[idx] = solve(from , to, map, visited);
            }
            idx++;
        }

        return ans;
    }

    public double solve(String from, String to, HashMap<String,HashMap<String,Double>> graph, HashSet<String> visited){
        if(from.equals(to)) return 1.0;
        
        visited.add(from);
        HashMap<String,Double> children = graph.get(from);

        double ans = 1.0;

        for(String key : children.keySet()){
            double val = children.get(key);

            if(!visited.contains(key)){
                double rr = solve(key, to, graph, visited);
                if(rr != -1){
                    return ans * val * rr;
                }
            }
        }
        
        return -1.0;
    }
}