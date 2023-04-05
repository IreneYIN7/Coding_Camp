package graphSearch;

import java.util.*;

public class BFS_dijkstra {
    private static boolean canReachTargetWithinCostLimit(Map<Integer, List<int[]>> graph, int target, int k, int costLimit) {
        // Create a priority queue to keep track of the edges with lowest weight
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[1], o2[1]); 
            }
          });
        pq.offer(new int[]{1, 0});
        
        // Create an array to keep track of the minimum cost to reach each node
        int[] costs = new int[target + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[1] = 0;
        
        // Perform Dijkstra's algorithm
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            
            if (cost > k) {
                continue;
            }
            
            if (node == target) {
                return true;
            }
            
            for (int[] neighbor : graph.get(node)) {
                System.out.println("node: " + node + " nei: " + neighbor[1]);
                int nextNode = neighbor[0];
                int nextCost = neighbor[1];
                System.out.println("nextCost: " + nextCost);
                if (nextCost <= costLimit && cost + nextCost < costs[nextNode]) {
                    costs[nextNode] = cost + nextCost;
                    pq.offer(new int[]{nextNode, costs[nextNode]});
                }
            }
            
        }
        return false;
    }
    
}
