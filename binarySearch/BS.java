package binarySearch;
import java.security.Principal;
import java.util.*;


public class BS {
    public int binarySearch(int[] array, int target) {
        // Write your solution here
        // use BS
        // 1 2 3 4 5
        //     mid
        // 1 2
        //   mid
        // 1
        int front = 0;
        int end = array.length - 1;
        while(front <= end){ 
          int mid = (end - front) / 2 + front; // <-- Error: forgot to add front to the mid. 
          if(array[mid] == target) return mid;
          else if(array[mid] > target) {
            end = mid - 1;
          }
          else{
            front = mid + 1;
          }
        }
        return -1;
    }
    // f           e
    // 3,4,5,6,6,9,16
    //       m
    // 3 4 5
    //   m
    // 5

    /**
     * Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. 
     * The first element of next row is larger than (or equal to) the last element of previous row.
     * Given a target number, returning the position that the target locates within the matrix. 
     * If the target number does not exist in the matrix, return {-1, -1}.
     */
    public int[] search(int[][] matrix, int target) {
        // Write your solution here
        // corner case:
        if(matrix.length == 0 && matrix[0].length == 0) return new int[]{-1,-1};
        //    0  1  2
        // 0  1, 2, 3
        // 1  4, 5, 7
        // 2  8, 9, 10
        int rowLength = matrix[0].length;
        int front = 0;
        int end = matrix.length* rowLength -1;
        while(front <= end){
          int midEle = (end - front) / 2 + front;
          int midRow = midEle / rowLength;
          int midCol = midEle % rowLength;
          if(matrix[midRow][midCol] == target) return new int[]{midRow, midCol};
          else if(matrix[midRow][midCol] > target) end = midEle - 1;
          else front = midEle + 1;
        }
        return new int[]{-1, -1};
    
      }
      // TC: O(log(m*n))
      // SC: O(1)
    
    public static void main(String args[]){
        BS solu = new BS();
        int[] a = new int[]{3,4,5,6,6,9,16};
        int target = 5;
        System.out.println(solu.binarySearch(a, target));
    }
    
}
