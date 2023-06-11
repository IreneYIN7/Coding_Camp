package graphSearch;
import java.util.*;

public class TheMazeII {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // If the value of position is 1, stop and turn to another position. 
        // there are 4 positions. Record the position that is avaliable to go. 
        // Note: shortestDistance -- Dijkstra (BFS) using priority queue
        // 1. Adj List? map all the possible moves at empty space?
        // 2. use PQ to add the total steps -- always pop the smallest one till PQ is empty. 

        // set a int[][] to record the visited position with its minimal total distance from the start
        int[][] distance = new int[maze.length][maze[0].length];
        for(int[] row : distance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // initial state
        distance[start[0]][start[1]] = 0;

        // 4 directions
        // right: [0,1], left: [0, -1], up [1, 0], down[-1,0]
        int[][] dirs = {{0, 1}, {0, -1}, {1,0}, {-1,0}};
        // using dijkstra algo
        // pq stores [x, y, steps]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[2] - b[2];
            }
        });

        minHeap.offer(new int[]{start[0], start[1], 0});

        while(!minHeap.isEmpty()){
            int[] curMin = minHeap.poll();
            int curX = curMin[0];
            int curY = curMin[1];
            int curSteps = curMin[2];
            // if curSteps < record steps continue
            if(curSteps < distance[curX][curY]) continue;
            // check for directions and possible total steps
            for(int[] dir: dirs){
                int x = curX + dir[0];
                int y = curY + dir[1];
                int counter = 0;
                // while not wall -- while can keep waling
                while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                    counter++;
                }

                // compare and add
                // since at this point, it hits the wall, so we need to back one step.
                if(distance[curX][curY] + counter < distance[x - dir[0]][y - dir[1]]){
                    // if smaller, update record and add to heap
                    distance[x - dir[0]][y - dir[1]] = distance[curX][curY] + counter;
                    minHeap.offer(new int[]{x - dir[0], y - dir[1], distance[x - dir[0]][y - dir[1]]});

                }
            }

        }
        
        // we already updated all the distance record for all positions.
        // need to find if the target has value smaller than MAX_VALUE;
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1:distance[destination[0]][destination[1]];
        
    }
    
}
