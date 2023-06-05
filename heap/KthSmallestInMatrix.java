import java.util.*;

public class KthSmallestInMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        // 1. use min heap --> generate a min heap based on matrix
        // corner case:
        if(matrix.length == 0 || k == 0) return -1;
    
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        PriorityQueue<cell> minHeap = new PriorityQueue<cell>(Math.min(numRows,k), new Comparator<cell>(){
          @Override
          public int compare(cell c1, cell c2){
            return c1.val - c2.val;
          }
        });
    
        for(int r = 0; r < Math.min(numRows, k); r ++){
          // add first ele from each row in matrix
          // add triplets of info for each cell
          minHeap.offer(new cell(matrix[r][0], r, 0));
        }
    
        cell curMin = minHeap.peek();
    
        // iterate k times to find the kth smallest
        while(k -- > 0){
    
          // extract min
          curMin = minHeap.poll();
          int r = curMin.row;
          int c = curMin.col;
    
          // if we have any new elements in the current row, add them
          if(c < numCols - 1){
            minHeap.offer(new cell(matrix[r][c+1], r, c+1));
          }
        }
    
        return curMin.val;
    
    
      }
    
      static class cell{
        int row;
        int col;
        int val;
    
        cell(int v, int r, int c){
          this.row = r;
          this.col = c;
          this.val = v;
        }
        
    }

    
}
