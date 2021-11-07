package HeadForOffer_II.Q111_Q119;

import java.util.*;

public class Q111 {
    public static void main(String[] args) {

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        Map<String, Map<String, Double>> map = new HashMap<>();
        map = buildMap(equations, values);
        double[] dd= new double[queries.size()];
        int i = 0;
        for (List<String> list : queries){
            if (!map.containsKey(list.get(0))||!map.containsKey(list.get(1))){
                dd[i++] = -1;
            } else {
                double k = dfs(map, list.get(1), list.get(0), new HashSet<>());
                dd[i++] = k;
            }
        }
        return dd;
    }

    private Map<String, Map<String, Double>> buildMap(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            Map<String,Double> map_log = map.getOrDefault(start,new HashMap<>());
            map_log.put(end,values[i]);
            map.put(start,map_log);
            // ---- 反向
            Map<String,Double> map_log_2 = map.getOrDefault(end,new HashMap<>());
            map_log_2.put(start,1 / values[i]);
            map.put(end,map_log_2);
        }
        return map;
    }

    private double dfs(Map<String, Map<String, Double>> map, String target, String start, Set<String> visited) {
        if (start.equals(target)){
            return 1.0;
        }
        visited.add(start);
        for (Map.Entry<String,Double> entry : map.get(start).entrySet()){
            if (!visited.contains(entry.getKey())) {
                double an = dfs(map, target, entry.getKey(), visited);
                if (an > 0) {
                    return an * entry.getValue();
                }
            }
        }
        visited.remove(start);
        return -1;
    }

}
