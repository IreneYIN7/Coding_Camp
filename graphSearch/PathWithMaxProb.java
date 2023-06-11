package graphSearch;
import java.util.*;
// import javafx.util.Pair; ?
public class PathWithMaxProb {
    // Solv by using dijkstra 
    public class Pair<K, V> {
        private final K key;
        private final V value;
    
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    
        public K getKey() {
            return key;
        }
    
        public V getValue() {
            return value;
        }
    }
      
    class Solution {

        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            // corner case
            if(edges.length == 0 || succProb.length == 0) return 0.0;
            // hashmap to keep track of the nodes visited
            Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
            // generating the adj list of nodes with corresponding prob.
            for(int i = 0; i < edges.length; i++){
                int u = edges[i][0], v = edges[i][1];
                double prob = succProb[i];
                graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, prob));
                graph.computeIfAbsent(v, k-> new ArrayList<>()).add(new Pair<>(u, prob));
            }
    
            double[] maxProb = new double[n];
            maxProb[start] = 1.0;
            PriorityQueue<Pair<Double, Integer>> maxHeap = new PriorityQueue<>(n, new Comparator<Pair<Double, Integer>>(){
                @Override
                public int compare(Pair<Double, Integer> a, Pair<Double, Integer>b){
                    if(a.getKey().equals(b.getKey())) return 0;
                    else if (a.getKey() > b.getKey()) return -1;
                    else return 1;
                }
            });
            // or use lamda expression: (a,b) -> -Double.compare(a.getKey(), b.getKey());
            maxHeap.add(new Pair<>(1.0, start));
            // while still not all visited
            while(!maxHeap.isEmpty()){
                Pair<Double, Integer> curMax = maxHeap.poll();
                double curMaxProb = curMax.getKey();
                int curNode = curMax.getValue();
                if(curNode == end) return curMaxProb;
                for (Pair<Integer, Double> nxt: graph.getOrDefault(curNode, new ArrayList<>())){
                    int nextNode = nxt.getKey();
                    double pathProb = nxt.getValue();
                    if(curMaxProb * pathProb > maxProb[nextNode]){
                        maxProb[nextNode] = curMaxProb * pathProb;
                        maxHeap.add(new Pair<>(maxProb[nextNode], nextNode));
                    }
                }
    
            }
    
            return 0.0;
    
    
    
        }
    }
    
}
