package graphSearch;
import java.util.*;

public class wallsAndGates {
    public int[][] wallsandGates(int[][] rooms) {
    // Write your solution here
    // when we meet -1, 0, it stays the same in the result
    // 1. meet -1, can't go, 
    // 2. 0 is the gate.
    // goal: fill room with nearest steps to gate.
    // step1: fill the INF around 0 as 1.
    // Step2: for each room, there is four possible direction. fill INF around 1 as 2.
    // Step3: redo step 2
    // use BFS -- queue FIFO. store each direction

    // corner case: 
    if(rooms.length == 0 || rooms[0].length == 0) return new int[][]{};
    int[][] result = new int[rooms.length][rooms[0].length];
    Arrays.stream(result).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
    // use Queue to store each position we need to fill.
    Deque<int[]> queue = new ArrayDeque<>();
    // fill queue with all gates and barries
    for(int i = 0; i < rooms.length; i ++){
      for(int j = 0; j < rooms[0].length; j++){
        if(rooms[i][j] == 0) {
          queue.offer(new int[]{i, j});
          result[i][j] = 0;
        }
        if(rooms[i][j] == -1) result[i][j] = -1;
      }
    }
    for(int i = 0; i < result.length; i++){
        System.out.println(Arrays.toString(result[i]));
    }
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    while(!queue.isEmpty()){
      int[] cur = queue.poll();
      int row = cur[0];
      int col = cur[1];
      int curStep = result[row][col];
      // check possible dir
      for(int[] dir: directions){
        int curRow = row + dir[0];
        int curCol = col + dir[1];
        // restriction1: 不能出界
        if(curRow >= 0 && curCol >= 0 && curRow < rooms.length && curCol < rooms[0].length){
          // restirction2: 必须是INF -- unfilled rooms
          if(result[curRow][curCol] == Integer.MAX_VALUE){ // 必须是INF
            // add to queue
            queue.offer(new int[]{curRow, curCol});
            result[curRow][curCol] = curStep + 1; // add 1 based on cur's steps
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args){
    wallsAndGates sol = new wallsAndGates();
    int[][] room = {{2147483647,-1,0,2147483647},
{2147483647,2147483647,2147483647,-1},
{2147483647,-1,2147483647,-1},
{0,-1,2147483647,2147483647}};
    int[][] res = sol.wallsandGates(room);
    for(int i = 0; i < res.length; i++) System.out.println(Arrays.toString(res[i]));
    Math.sqrt(Math.pow(10,2)); 
  }
    
}
