package graphSearch;
import java.util.*;

public class NetworkDelayTime {
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
      
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. create an adj list with its time needs.
        //    keep track of node visited.
        // 1.2 create time record list to record each node's receive time.
        
        // 2. use pq - maxHeap to store the time.
        //    find the min time from v to w add to the maxHeap.

        // 3. while !pq.isEmpty(), still some to explore. 
        //    otherwise, every node is visited, and updated the record time list.

        // corner case:
        if(times.length == 0 || n == 0 || k == 0) return -1;

        // generate an adj list
        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();
        for (int i = 0; i < times.length; i ++){
            int u = times[i][0], v = times[i][1];
            int time = times[i][2];
            // graph.computeIfAbsent(u, m -> new ArrayList<>()).add(new Pair(v, time));
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new Pair(v, time));
        }

        // generate an array with large value to show that hasn't receive signal
        int[] signalReceivedAt = new int[n + 1]; // since we have 1- n node
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        // generate a pq
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>(){
            @Override
            public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b){
                return a.getValue() - b.getValue();
            }
        });
        minHeap.offer(new Pair(k, 0));

        // change source time records
        signalReceivedAt[k] = 0;

        while(!minHeap.isEmpty()){
            Pair<Integer, Integer> curMin = minHeap.poll();
            int curNode = curMin.getKey();
            int curTime = curMin.getValue();

            // if curTime > the exist time record, continue.
            if(curTime > signalReceivedAt[curNode]) continue;
            // if the curNode is the end (not neighbs) end;
            if(!graph.containsKey(curNode)) continue;
            // if curNode has neighbors and curTime < time recorded
            for(Pair<Integer, Integer> edge : graph.getOrDefault(curNode, new ArrayList<>())){
                int nextNode = edge.getKey();
                int nextNodeTime = edge.getValue();
                // get total time for each adj node
                int timeTotal = curTime + nextNodeTime;
                if(signalReceivedAt[nextNode] > timeTotal){
                    signalReceivedAt[nextNode] = timeTotal;
                    minHeap.offer(new Pair(nextNode, timeTotal));
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= n ; i++){
            answer = Math.max(answer, signalReceivedAt[i]);

        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
        
    }

}
