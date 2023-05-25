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
    
    public static void main(String args[]){
        BS solu = new BS();
        int[] a = new int[]{3,4,5,6,6,9,16};
        int target = 5;
        System.out.println(solu.binarySearch(a, target));
    }
    
}
