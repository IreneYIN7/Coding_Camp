package graphSearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class evaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // output: find values of the pairs in the queries from the equations given
        // build a graph based on the equation.
        // using graph search finding the result.

        // corner case:
        if(equations.size() == 0 || values.length == 0 || (equations.size() != values.length)) return new double[]{-1};

        // step 1: build graph
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            String from = equation.get(0), to = equation.get(1);
            double val = values[i];
            // if (!map.containsKey(from))
            //     map.put(from, new HashMap<String, Double>());
            // if (!map.containsKey(to))
            //     map.put(to, new HashMap<String, Double>());
            // map.get(from).put(to, val);
            // map.get(to).put(from, 1 / val);

            map.computeIfAbsent(from, k -> new HashMap<String, Double>()).put(to, val);
            map.computeIfAbsent(to, k-> new HashMap<String, Double>()).put(from, 1/val);
            // map.computeIfAbsent(from, k -> new ArrayList<>()).add(new Pair(to, val));
            // map.computeIfAbsent(to, k-> new ArrayList<>()).add(new Pair(from, 1/val));
        }
        System.out.println(map.toString());

        // step 2: find values
        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            String from = query.get(0), to = query.get(1);

            // basecase:
            if(!map.containsKey(from) || !map.containsKey(to)) result[i] = -1.0;
            else if(from == to) result[i] = 1.0;
            else{
                // using dfs - backtracking
                Set<String> visited = new HashSet<>();
                result[i] = dfsEval(map, from, to, 1, visited);
            }
        }
        return result;
    }

    private double dfsEval(HashMap<String, HashMap<String, Double>> map, String from, String to, double curProd, Set<String> visited){

        // mark the visit - base case
        visited.add(from);
        double res = -1.0;
        HashMap<String, Double> neighbors = map.get(from);
        if(neighbors.containsKey(to)){ // if there is direct path.
            res = curProd * neighbors.get(to);
        }
        else{ // if need transaction to get to target
            for(Map.Entry<String, Double> pair : neighbors.entrySet()){
                String nextNode = pair.getKey();
                // if viisted, next
                if(visited.contains(nextNode)) continue;
                res = dfsEval(map, nextNode, to, curProd * pair.getValue(), visited);
                if(res != -1.0) break;
            }
        }
        // unmark the visit -- backtracking.
        visited.remove(from);
        return res;
    }
    
}
