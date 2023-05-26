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

    /**
     * Given a target integer T and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to T.

Assumptions

There can be duplicate elements in the array, and we can return any of the indices with same value.
     */
    public int closest(int[] array, int target) {
        // Write your solution here
        // corner case:
        if(array.length == 0 || array == null) return -1;
        // 1 4 6
        //   m
        // 1 4
        // when there is only 2 element left, stop and check
        int front = 0;
        int end = array.length - 1;
        while(front < end - 1){ // 2 elements left
          int mid = (end - front) /2 + front;
          System.out.println(mid);
          if(array[mid] == target) return mid;
          else if(array[mid] > target){
            end = mid;
            System.out.println("front " + front);
          }
          else {
            front = mid;
            System.out.println("end " + end);
          }
        }
    
        // check closest:
        System.out.println("front: " + front + " end: " + end);
        if(Math.abs(array[front]-target) > Math.abs(array[end] - target)) return end;
        else return front;
      }
      // 3,4,5,6,6,12,16  f = 0, e = 6, m = 3
      //       m
      // 6,6,12,16        f = 3, e = 6, m = 4
      //   m
      // 6,12, 16         f = 4, e = 6, m = 5
      //   m
      // 6, 12            f = 4, e = 5, m -- pass
      // t
    
    /**
     * Given a target integer T and an integer array A sorted in ascending order, find the index of the first occurrence of T in A or return -1 if there is no such index.

    Assumptions: There can be duplicate elements in the array.
     */

     public int firstOccur(int[] array, int target) {
        //corner case:
        if(array == null || array.length == 0) return -1;
        // found target first, then check neighbors
        int found = binarySearch(array, target);
        System.out.println(found);
        if (found <= 0) return found;
        else{
          // found target
          while(found > 0){ // can't be >=, since 0-1 = -1 --> out of index
            if(array[found] == array[found - 1]) found -= 1;
            else return found;
          }
          return found;
        }
    
      }
      public int lastOccur(int[] array, int target) {
        // Write your solution here
        int found = binarySearch(array, target);
        if (found < 0) return found;
        while(found < array.length - 1){
          if(array[found] == array[found + 1]) found += 1;
          else return found;
        }
        return found;
      }

      public int lastOccur2(int[] array, int target){
        int front = 0;
        int end = array.length - 1;
        // get two element
        while(front < end - 1){
          int mid = (end - front) / 2 + front;
          if(array[mid] <= target) front = mid;
          else end = mid;
        }
        if(array[end] == target) return end;
        else if(array[front] == target) return front;
        else return -1;
      }

    public static void main(String args[]){
        BS solu = new BS();
        int[] a = new int[]{3,4,5,6,6,9,16};
        int target = 3;
        // System.out.println(solu.binarySearch(a, target));
        System.out.println(solu.firstOccur(a, target));
    }
    
}
