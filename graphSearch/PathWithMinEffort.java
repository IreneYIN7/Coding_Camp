package graphSearch;
import java.util.*;
public class PathWithMinEffort {
    public int minimumEffortPath(int[][] heights) {
        // use dijkstra algo
        // 1. int[][] to record the effort difference for each position
        // 2. use PQ min heap to heapify the effort. Always use the top -- the min effort then start from there find the neighbour's effort difference.
        // 3. compare to the current effort with the neighbors', if smaller, than update effort diff and add to heap
        // 4. the result is the right-bottom in the effort record int[][]
        // additional: also needs a boolean[] visited to keep track of the position visited.

        // corner case:
        if(heights.length == 0) return 0;

        // generate effort record chart
        int[][] efforts = new int[heights.length][heights[0].length];
        
        for (int[] row : efforts) Arrays.fill(row, Integer.MAX_VALUE);
        efforts[0][0] = 0;

        int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        visited[0][0] = true;
        // pq [x, y, effort]

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[2] - b[2];
            }
        });
        minHeap.offer(new int[]{0, 0, efforts[0][0]});
        while(!minHeap.isEmpty()){
            int[] curMin = minHeap.poll();
            int minEffort = curMin[2];
            visited[curMin[0]][curMin[1]] = true;
            // problem here
            if(efforts[curMin[0]][curMin[1]] < minEffort) continue;
            // iterate possible directions
            for(int[] dir : dirs){
                int x = curMin[0] + dir[0];
                int y = curMin[1] + dir[1];
                if(x >= 0 && y >= 0 && x < heights.length && y < heights[0].length && !visited[x][y]){
                    // check for effort diff
                    int effortDiff = Math.abs(heights[x][y] - heights[curMin[0]][curMin[1]]);
                    int maxDifference = Math.max(effortDiff, efforts[curMin[0]][curMin[1]]);

                    // compare and add
                    if(efforts[x][y] > maxDifference){
                        efforts[x][y] = maxDifference;
                        minHeap.add(new int[]{x, y, maxDifference});
                    }
                }
            }
        }

        return efforts[heights.length-1][heights[0].length-1];


    }
}
